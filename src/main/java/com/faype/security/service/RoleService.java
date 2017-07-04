package com.faype.security.service;

import com.faype.security.core.service.GenericService;
import com.faype.security.domain.Role;
import com.faype.security.repository.RoleRepository;
import org.springframework.stereotype.Service;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Service
public class RoleService extends GenericService<RoleRepository, Role, String> {
}
