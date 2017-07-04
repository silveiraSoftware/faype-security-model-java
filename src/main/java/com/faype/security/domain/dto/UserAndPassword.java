package com.faype.security.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by wmfsystem on 7/3/17.
 */
public class UserAndPassword {

    public String login;

    public String password;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String newPassword;
}
