package com.faype.security.service;

import com.faype.security.core.service.GenericService;
import com.faype.security.domain.Organization;
import com.faype.security.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Service
public class OrganizationService extends GenericService<OrganizationRepository, Organization, String> {
}
