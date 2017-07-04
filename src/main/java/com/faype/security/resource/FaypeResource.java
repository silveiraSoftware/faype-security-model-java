package com.faype.security.resource;

import com.faype.security.core.resource.GenericResource;
import com.faype.security.domain.Instance;
import com.faype.security.service.FaypeService;
import com.faype.security.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wmfsystem on 7/3/17.
 */
@RestController
@RequestMapping("/public/faype-security")
public class FaypeResource {

    @Autowired
    private FaypeService service;
}
