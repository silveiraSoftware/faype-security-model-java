package com.faype.security.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Document
public class Organization extends Person {

    private List<User> mainUsers;

    private String socialName;

    private String clientId;

    private Boolean softwareHouse;

    private Long maxShortTokens;

    private List<User> users;

    private List<Organization> subOrganizations;

    public Organization() {
    }

    public List<User> getMainUsers() {
        return mainUsers;
    }

    public void setMainUsers(List<User> mainUsers) {
        this.mainUsers = mainUsers;
    }

    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Boolean getSoftwareHouse() {
        return softwareHouse;
    }

    public void setSoftwareHouse(Boolean softwareHouse) {
        this.softwareHouse = softwareHouse;
    }

    public Long getMaxShortTokens() {
        return maxShortTokens;
    }

    public void setMaxShortTokens(Long maxShortTokens) {
        this.maxShortTokens = maxShortTokens;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Organization> getSubOrganizations() {
        return subOrganizations;
    }

    public void setSubOrganizations(List<Organization> subOrganizations) {
        this.subOrganizations = subOrganizations;
    }
}
