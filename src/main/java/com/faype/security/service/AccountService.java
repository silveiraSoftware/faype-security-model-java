package com.faype.security.service;

import com.faype.security.domain.Token;
import com.faype.security.domain.User;
import com.faype.security.domain.dto.UserAndPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Service
public class AccountService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    private Token SignIn(UserAndPassword userAndPassword) {
        return null;
    }

    private void SignOut(String token) {

    }

    private Token register(User user) {
        userService.save(user);
        return null;
    }

}
