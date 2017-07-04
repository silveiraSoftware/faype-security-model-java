package com.faype.security.core.domain;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @param <ID> Id
 * @author wmfsystem
 */
//    org.springframework.data.mongodb.core.mapping
//@Document
public abstract class GenericDomain<ID extends Serializable> implements Serializable {

    @Id
    protected ID id;

    protected LocalDateTime createdAt;

    public GenericDomain() {
        this.createdAt = LocalDateTime.now();
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
