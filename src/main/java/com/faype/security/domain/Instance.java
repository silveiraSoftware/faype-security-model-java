package com.faype.security.domain;

import com.faype.security.core.domain.GenericDomain;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Document
public class Instance extends GenericDomain<String> {

    private String name;

    private LocalDateTime expiration;

    private String customInformation;

    private Long tokenDuration;

    private Organization organization;

    @Transient
    public List<Role> roles;

    private List<InstanceValues> instanceValues;

    public Instance() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDateTime expiration) {
        this.expiration = expiration;
    }

    public String getCustomInformation() {
        return customInformation;
    }

    public void setCustomInformation(String customInformation) {
        this.customInformation = customInformation;
    }

    public Long getTokenDuration() {
        return tokenDuration;
    }

    public void setTokenDuration(Long tokenDuration) {
        this.tokenDuration = tokenDuration;
    }

    public List<InstanceValues> getInstanceValues() {
        return instanceValues;
    }

    public void setInstanceValues(List<InstanceValues> instanceValues) {
        this.instanceValues = instanceValues;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
