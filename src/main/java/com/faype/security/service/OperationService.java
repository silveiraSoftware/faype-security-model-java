package com.faype.security.service;

import com.faype.security.core.service.GenericService;
import com.faype.security.domain.Operation;
import com.faype.security.repository.OperationRepository;
import org.springframework.stereotype.Service;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Service
public class OperationService extends GenericService<OperationRepository, Operation, String> {
}
