package com.faype.security.service;

import com.faype.security.core.service.GenericService;
import com.faype.security.domain.OperationGroup;
import com.faype.security.repository.OperationGroupRepository;
import org.springframework.stereotype.Service;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Service
public class OperationGroupService extends GenericService<OperationGroupRepository, OperationGroup, String> {
}
