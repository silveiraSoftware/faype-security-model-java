package com.faype.security.domain;

import com.faype.security.core.domain.GenericDomain;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by wmfsystem on 7/3/17.
 */
public abstract class Person extends GenericDomain<String> {

    @Field(value = "name")
    @NotEmpty(message = "The name can not be empty.")
    private String name;

    @Field(value = "hierarchyCode")
    private String hierarchyCode;

    @Field(value = "internalCode")
    private String internalCode;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHierarchyCode() {
        return hierarchyCode;
    }

    public void setHierarchyCode(String hierarchyCode) {
        this.hierarchyCode = hierarchyCode;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }
}
