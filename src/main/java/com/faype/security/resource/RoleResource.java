package com.faype.security.resource;

import com.faype.security.core.resource.GenericResource;
import com.faype.security.domain.Role;
import com.faype.security.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wmfsystem on 7/3/17.
 */
@RestController
@RequestMapping("/api/role")
public class RoleResource extends GenericResource<RoleService, Role, String> {
}
