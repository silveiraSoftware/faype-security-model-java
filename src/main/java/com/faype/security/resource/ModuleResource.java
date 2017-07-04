package com.faype.security.resource;

import com.faype.security.core.resource.GenericResource;
import com.faype.security.domain.Module;
import com.faype.security.service.ModuleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wmfsystem on 7/3/17.
 */
@RestController
@RequestMapping("/api/module")
public class ModuleResource extends GenericResource<ModuleService, Module, String> {
}
