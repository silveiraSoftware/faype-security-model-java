package com.faype.security.resource;

import com.faype.security.core.resource.GenericResource;
import com.faype.security.domain.Specification;
import com.faype.security.service.SpecificationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wmfsystem on 7/3/17.
 */
@RestController
@RequestMapping("/api/specification")
public class SpecificationResource extends GenericResource<SpecificationService, Specification, String> {
}
