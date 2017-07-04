package com.faype.security.service;

import com.faype.security.core.service.GenericService;
import com.faype.security.domain.User;
import com.faype.security.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Service
public class UserService extends GenericService<UserRepository, User, String> {
}
