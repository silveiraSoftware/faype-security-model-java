package com.faype.security.domain;

import com.faype.security.core.domain.GenericDomain;

/**
 * Created by wmfsystem on 7/3/17.
 */
public abstract class AdditionalValues {

    private String key;

    private String value;

    public AdditionalValues() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
