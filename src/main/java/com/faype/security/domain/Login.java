package com.faype.security.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by wmfsystem on 7/3/17.
 */
public class Login {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String login;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String password;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String token;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private LoginType type;

    public Login() {
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginType getType() {
        return type;
    }

    public void setType(LoginType type) {
        this.type = type;
    }
}
