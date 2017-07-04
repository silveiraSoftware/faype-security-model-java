package com.faype.security.core.repository;

import com.faype.security.core.domain.GenericDomain;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;

/**
 *
 * @author wmfsystem
 * @param <T> WDomain
 * @param <ID> Type of Id
 */
//@NoRepositoryBean
public interface GenericRepository<T extends GenericDomain, ID extends Serializable> extends MongoRepository<T, ID> {
    
}
