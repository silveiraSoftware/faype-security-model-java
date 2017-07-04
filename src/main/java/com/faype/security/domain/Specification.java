package com.faype.security.domain;

import com.faype.security.core.domain.GenericDomain;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Document
public class Specification extends GenericDomain<String> {

    private Role role;

    private Operation operation;

    private SpecificationType type;

    public Specification() {
    }

    public SpecificationType getType() {
        return type;
    }

    public void setType(SpecificationType type) {
        this.type = type;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
