package com.faype.security.resource;

import com.faype.security.core.resource.GenericResource;
import com.faype.security.domain.User;
import com.faype.security.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wmfsystem on 7/3/17.
 */
@RestController
@RequestMapping("/api/user")
public class UserResource extends GenericResource<UserService, User, String> {
}
