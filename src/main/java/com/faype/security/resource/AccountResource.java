package com.faype.security.resource;

import com.faype.security.service.AccountService;
import com.faype.security.service.FaypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wmfsystem on 7/3/17.
 */
@RestController
@RequestMapping("/public/account")
public class AccountResource {

    @Autowired
    private AccountService service;


}
