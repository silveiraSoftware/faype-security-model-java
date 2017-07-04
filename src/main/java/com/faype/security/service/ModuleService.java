package com.faype.security.service;

import com.faype.security.core.service.GenericService;
import com.faype.security.domain.Module;
import com.faype.security.repository.ModuleRepository;
import org.springframework.stereotype.Service;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Service
public class ModuleService extends GenericService<ModuleRepository, Module, String> {
}
