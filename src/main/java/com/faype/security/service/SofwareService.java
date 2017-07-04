package com.faype.security.service;

import com.faype.security.core.service.GenericService;
import com.faype.security.domain.Software;
import com.faype.security.repository.SoftwareRepository;
import org.springframework.stereotype.Service;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Service
public class SofwareService extends GenericService<SoftwareRepository, Software, String> {
}
