package com.faype.security.repository;

import com.faype.security.core.repository.GenericRepository;
import com.faype.security.domain.Operation;
import org.springframework.stereotype.Repository;

/**
 * Created by wmfsystem on 7/3/17.
 */
@Repository
public interface OperationRepository extends GenericRepository<Operation, String> {
}
