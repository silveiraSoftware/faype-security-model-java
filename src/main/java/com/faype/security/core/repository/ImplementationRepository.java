package com.faype.security.core.repository;

import com.faype.security.core.domain.GenericDomain;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by wmfsystem on 5/27/17.
 */
@NoRepositoryBean
public class ImplementationRepository<T extends GenericDomain, ID extends Serializable> implements MongoRepository<T, ID> {

    T domain;
    private final MongoOperations mongoOperations;
    private MongoEntityInformation<T, ID> entityInformation;

    public ImplementationRepository(MongoEntityInformation<T, ID> metadata, MongoOperations mongoOperations) {

        Assert.notNull(mongoOperations);
        Assert.notNull(metadata);

        this.entityInformation = metadata;
        this.mongoOperations = mongoOperations;
    }

    private Query queryTenancy() {
        Query query = new Query();
        query.addCriteria(criteriaTenancy());
        return query;
    }

    private static Criteria criteriaTenancy() {
//        return Criteria.where("identity.oi").gte(WThreadScope.organizationId.get())
//                .and("identity.pi").gte(WThreadScope.personId.get());
        return Criteria.where("");
    }

    private void setIdentity(GenericDomain domain) {
        //TODO
    }

    private String firsLevel(String oi) {
        return "";
    }

    private boolean isPresentMultTenancy(Object entity) {
        Class<?> aClass = entity.getClass();
        if (aClass.getSuperclass().equals(GenericDomain.class)) {
            return true; //aClass.isAnnotationPresent(MultiTenancy.class);
        }
        return false;
    }

    public <S extends T> S save(S entity) {

        if (isPresentMultTenancy(entity)) {
            setIdentity(entity);
        }

        org.springframework.util.Assert.notNull(entity,
                "Entity must not be null!");

        if (entityInformation.isNew(entity)) {
            mongoOperations.insert(entity, entityInformation.getCollectionName());
        } else {
            mongoOperations.save(entity, entityInformation.getCollectionName());
        }

        return entity;
    }

    /*
     * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Iterable)
     */
    public <S extends T> List<S> save(Iterable<S> entities) {

        org.springframework.util.Assert.notNull(entities, "The given Iterable of entities not be null!");

        List<S> result = convertIterableToList(entities);
        boolean allNew = true;

        for (S entity : entities) {
            if (isPresentMultTenancy(entity)) {
                setIdentity(entity);
            }
            if (allNew && !entityInformation.isNew(entity)) {
                allNew = false;
            }
        }

        if (allNew) {
            mongoOperations.insertAll(result);
        } else {

            for (S entity : result) {
                save(entity);
            }
        }

        return result;
    }

    public T findOne(ID id) {
        org.springframework.util.Assert.notNull(id, "The given id must not be null!");
        Query q = queryTenancy();
        q.addCriteria(Criteria.where("id").is(id));

        return mongoOperations.findOne(q, entityInformation.getJavaType());

//        return mongoOperations.findById(id, entityInformation.getJavaType(), entityInformation.getCollectionName());
    }

    private Query getIdQuery(Object id) {
        return new Query(getIdCriteria(id));
    }

    private Criteria getIdCriteria(Object id) {
        Criteria criteria = criteriaTenancy().where(entityInformation.getIdAttribute()).is(id);
        return criteria;
    }

    public boolean exists(ID id) {
        org.springframework.util.Assert.notNull(id, "The given id must not be null!");
        return mongoOperations.exists(getIdQuery(id), entityInformation.getJavaType(),
                entityInformation.getCollectionName());
    }

    /*
     * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#count()
     */
    public long count() {
        return mongoOperations.getCollection(entityInformation.getCollectionName()).count();
    }

    /*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#delete(java.io.Serializable)
     */
    public void delete(ID id) {
        org.springframework.util.Assert.notNull(id, "The given id must not be null!");
        mongoOperations.remove(getIdQuery(id), entityInformation.getJavaType(), entityInformation.getCollectionName());
    }

    /*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
     */
    public void delete(T entity) {
        org.springframework.util.Assert.notNull(entity, "The given entity must not be null!");
        delete(entityInformation.getId(entity));
    }

    /*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Iterable)
     */
    public void delete(Iterable<? extends T> entities) {

        org.springframework.util.Assert.notNull(entities, "The given Iterable of entities not be null!");

        for (T entity : entities) {
            delete(entity);
        }
    }

    /*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#deleteAll()
     */
    public void deleteAll() {
        mongoOperations.remove(new Query(), entityInformation.getCollectionName());
    }

    /*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findAll()
     */
    public List<T> findAll() {
        return findAll(new Query());
    }

    /*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Pageable)
     */
    public Page<T> findAll(final Pageable pageable) {

        Long count = count();

        List<T> list = findAll(new Query());

        return new PageImpl<T>(list, pageable, count);
    }

    /*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Sort)
     */
    public List<T> findAll(Sort sort) {
        return findAll(new Query().with(sort));
    }

    /*
	 * (non-Javadoc)
	 * @see org.springframework.data.mongodb.repository.MongoRepository#insert(java.lang.Object)
     */
    @Override
    public <S extends T> S insert(S entity) {

        org.springframework.util.Assert.notNull(entity, "Entity must not be null!");

        mongoOperations.insert(entity, entityInformation.getCollectionName());
        return entity;
    }

    /*
	 * (non-Javadoc)
	 * @see org.springframework.data.mongodb.repository.MongoRepository#insert(java.lang.Iterable)
     */
    @Override
    public <S extends T> List<S> insert(Iterable<S> entities) {

        org.springframework.util.Assert.notNull(entities, "The given Iterable of entities not be null!");

        List<S> list = convertIterableToList(entities);

        if (list.isEmpty()) {
            return list;
        }

        mongoOperations.insertAll(list);
        return list;
    }


    /*
	 * (non-Javadoc)
	 * @see org.springframework.data.mongodb.repository.MongoRepository#findAllByExample(org.springframework.data.domain.Example, org.springframework.data.domain.Sort)
     */
    @Override
    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {

        org.springframework.util.Assert.notNull(example, "Sample must not be null!");

        Query q = new Query(new Criteria().alike(example));

        if (sort != null) {
            q.with(sort);
        }

        return mongoOperations.find(q, example.getProbeType(), entityInformation.getCollectionName());
    }

    /*
	 * (non-Javadoc)
	 * @see org.springframework.data.mongodb.repository.MongoRepository#findAllByExample(org.springframework.data.domain.Example)
     */
    @Override
    public <S extends T> List<S> findAll(Example<S> example) {
        return findAll(example, (Sort) null);
    }

    /*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.query.QueryByExampleExecutor#findOne(org.springframework.data.domain.Example)
     */
    @Override
    public <S extends T> S findOne(Example<S> example) {

        org.springframework.util.Assert.notNull(example, "Sample must not be null!");

        Query q = queryTenancy();
        q.addCriteria(new Criteria().alike(example));

        return mongoOperations.findOne(q, example.getProbeType(), entityInformation.getCollectionName());
    }

    /*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.query.QueryByExampleExecutor#count(org.springframework.data.domain.Example)
     */
    @Override
    public <S extends T> long count(Example<S> example) {

        org.springframework.util.Assert.notNull(example, "Sample must not be null!");

        Query q = queryTenancy();
        q.addCriteria(new Criteria().alike(example));

        return mongoOperations.count(q, example.getProbeType(), entityInformation.getCollectionName());
    }

    /*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.query.QueryByExampleExecutor#exists(org.springframework.data.domain.Example)
     */
    @Override
    public <S extends T> boolean exists(Example<S> example) {

        org.springframework.util.Assert.notNull(example, "Sample must not be null!");

        Query q = queryTenancy();
        q.addCriteria(new Criteria().alike(example));

        return mongoOperations.exists(q, example.getProbeType(), entityInformation.getCollectionName());
    }

    private List<T> findAll(Query query) {

        query.addCriteria(criteriaTenancy());

        if (query == null) {
            return Collections.emptyList();
        }

        return mongoOperations.find(query, entityInformation.getJavaType(), entityInformation.getCollectionName());
    }

    private static <T> List<T> convertIterableToList(Iterable<T> entities) {

        if (entities instanceof List) {
            return (List<T>) entities;
        }

        int capacity = tryDetermineRealSizeOrReturn(entities, 10);

        if (capacity == 0 || entities == null) {
            return Collections.<T>emptyList();
        }

        List<T> list = new ArrayList<T>(capacity);
        for (T entity : entities) {
            list.add(entity);
        }

        return list;
    }

    private static int tryDetermineRealSizeOrReturn(Iterable<?> iterable, int defaultSize) {
        return iterable == null ? 0 : (iterable instanceof Collection) ? ((Collection<?>) iterable).size() : defaultSize;
    }

    @Override
    public Iterable<T> findAll(Iterable<ID> itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <S extends T> Page<S> findAll(Example<S> exmpl, Pageable pgbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}