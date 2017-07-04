package com.faype.security.domain;

import com.faype.security.core.domain.GenericDomain;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Document
public class Operation extends GenericDomain<String> {

    private String name;

    private String description;

    private String key;

    private Boolean basicOperation;

    private String billed;

    private Double thousandValue;

    private Product product;

    public Operation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getBasicOperation() {
        return basicOperation;
    }

    public void setBasicOperation(Boolean basicOperation) {
        this.basicOperation = basicOperation;
    }

    public String getBilled() {
        return billed;
    }

    public void setBilled(String billed) {
        this.billed = billed;
    }

    public Double getThousandValue() {
        return thousandValue;
    }

    public void setThousandValue(Double thousandValue) {
        this.thousandValue = thousandValue;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}