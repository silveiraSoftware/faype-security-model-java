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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenericDomain<?> that = (GenericDomain<?>) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return createdAt != null ? createdAt.equals(that.createdAt) : that.createdAt == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GenericDomain{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                '}';
    }
}
