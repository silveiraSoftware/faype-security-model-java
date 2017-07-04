package com.faype.security.domain;

import com.faype.security.core.domain.GenericDomain;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Document
public class Role extends GenericDomain<String> {

    private String name;

    @Transient
    public List<Specification> specifications;

    public Role() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
