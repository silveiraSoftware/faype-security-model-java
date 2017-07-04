package com.faype.security.service;

import com.faype.security.core.service.GenericService;
import com.faype.security.domain.Specification;
import com.faype.security.repository.SpecificationRepository;
import org.springframework.stereotype.Service;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Service
public class SpecificationService extends GenericService<SpecificationRepository, Specification, String> {
}
