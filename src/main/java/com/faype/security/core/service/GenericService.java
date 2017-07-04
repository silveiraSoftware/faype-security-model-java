package com.faype.security.core.service;

import com.faype.security.core.domain.GenericDomain;
import com.faype.security.core.domain.QueryObject;
import com.faype.security.core.domain.SearchResponse;
import com.faype.security.core.exception.DomainExistenceException;
import com.faype.security.core.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @param <D> Id
 * @param <E> WDomain
 * @author wmfsystem
 */
@Service
@Scope(value = "prototype")
public abstract class GenericService<F extends GenericRepository, E extends GenericDomain, D extends Serializable> {

    @Autowired
    protected F repository;

    @Transactional
    public SearchResponse<List<E>> findAll(QueryObject queryObject) {
        Page page = repository.findAll(new PageRequest(queryObject.getStart(), queryObject.getPageSize()));
        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setCount(page.getTotalElements());
        searchResponse.setPageSize(queryObject.getPageSize());
        searchResponse.setStart(queryObject.getStart());
        searchResponse.setValues(page.getContent());
        return searchResponse;
    }

    @Transactional
    public SearchResponse<List<E>> findAll() {
        QueryObject queryObject = new QueryObject();
        Page page = repository.findAll(new PageRequest(queryObject.getStart(), queryObject.getPageSize()));
        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setCount(page.getTotalElements());
        searchResponse.setPageSize(queryObject.getPageSize());
        searchResponse.setStart(queryObject.getStart());
        searchResponse.setValues(page.getContent());
        return searchResponse;
    }

    public E save(E obj) {
        boolean isUpdate = false;
        if (obj.getId() != null) {
            E verifyId = (E) repository.findOne(obj.getId());

            if (verifyId != null) {
                throw new DomainExistenceException("This Domain exists!");
            }

            isUpdate = true;
            this.beforeUpdate(obj);
        } else {
            this.beforeSave(obj);
        }
        obj.setCreatedAt(LocalDateTime.now());

        Object object = repository.save(obj);

        if (isUpdate) {
            afterUpdate((E) object);
        } else {
            afterSave((E) object);
        }
        return (E) object;
    }

    public void beforeSave(E obj) {

    }

    public void afterSave(E obj) {

    }

    public void beforeUpdate(E obj) {

    }

    public void afterUpdate(E obj) {

    }

    public E findOne(Serializable id) {
        E object = (E) repository.findOne(id);

        return object;
    }

    public void delete(Serializable id) {
        try {
            repository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            throw new DataIntegrityViolationException("Erro ao deletar!");
        }
    }

    public E update(E object) {
        E actualObject = (E) verifyExists(object);
        Object after = repository.save(object);
        return (E) after;
    }

    public Object verifyExists(E object) {
        return findOne(object.getId());
    }



}
