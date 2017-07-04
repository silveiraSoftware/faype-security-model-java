package com.faype.security.domain;

import com.faype.security.core.domain.GenericDomain;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Document
public class Token extends GenericDomain<String> {

    private User user;

    private String information;

    private LocalDateTime expirateAt;

    private String value;

    public Token() {
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public LocalDateTime getExpirateAt() {
        return expirateAt;
    }

    public void setExpirateAt(LocalDateTime expirateAt) {
        this.expirateAt = expirateAt;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        UUID uuid = UUID.fromString(user.toString());
        String token = uuid.toString();


    }
}
