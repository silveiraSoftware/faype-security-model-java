package com.faype.security.resource;

import com.faype.security.core.resource.GenericResource;
import com.faype.security.domain.Organization;
import com.faype.security.service.OrganizationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wmfsystem on 7/3/17.
 */
@RestController
@RequestMapping("/api/organization")
public class OrganizationResource extends GenericResource<OrganizationService, Organization, String> {
}
