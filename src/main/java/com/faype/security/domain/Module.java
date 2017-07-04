package com.faype.security.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Document
public class Module extends Product {

    private Software software;

    private String name;

    private String url;

    private List<Module> subModules;

    public Module() {
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
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

    public List<Module> getSubModules() {
        return subModules;
    }

    public void setSubModules(List<Module> subModules) {
        this.subModules = subModules;
    }
}
