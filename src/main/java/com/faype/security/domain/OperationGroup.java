package com.faype.security.domain;

import com.faype.security.core.domain.GenericDomain;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Document
public class OperationGroup extends GenericDomain<String> {

    private String name;

    private List<Operation> operations;

    public OperationGroup() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
