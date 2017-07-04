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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Person person = (Person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (hierarchyCode != null ? !hierarchyCode.equals(person.hierarchyCode) : person.hierarchyCode != null)
            return false;
        return internalCode != null ? internalCode.equals(person.internalCode) : person.internalCode == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (hierarchyCode != null ? hierarchyCode.hashCode() : 0);
        result = 31 * result + (internalCode != null ? internalCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", hierarchyCode='" + hierarchyCode + '\'' +
                ", internalCode='" + internalCode + '\'' +
                '}';
    }
}
