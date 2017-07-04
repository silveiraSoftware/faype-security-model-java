package com.faype.security.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by wmfsystem on 5/27/17.
 */
@Document(collection = "User")
public class User extends Person {

    @NotEmpty(message = "The email can not be empty.")
    private String email;

    @NotEmpty(message = "The name can not be empty.")
    private String login;

    private String password;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String newPassword;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Login> logins;

    private List<Organization> organizations;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public List<Login> getLogins() {
        return logins;
    }

    public void setLogins(List<Login> logins) {
        this.logins = logins;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }
}
