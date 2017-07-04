package com.faype.security.domain;

import com.faype.security.core.domain.GenericDomain;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Document(collection = "Software")
public class Software extends Product {

    private String name;

    private String url;

    private Long tokenDuration;

    private List<SoftwareValues> softwareValues;

    public Software() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getTokenDuration() {
        return tokenDuration;
    }

    public void setTokenDuration(Long tokenDuration) {
        this.tokenDuration = tokenDuration;
    }

    public List<SoftwareValues> getSoftwareValues() {
        return softwareValues;
    }

    public void setSoftwareValues(List<SoftwareValues> softwareValues) {
        this.softwareValues = softwareValues;
    }
}
