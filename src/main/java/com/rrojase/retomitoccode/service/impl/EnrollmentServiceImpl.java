package com.rrojase.retomitoccode.service.impl;

import com.rrojase.retomitoccode.model.Enrollment;
import com.rrojase.retomitoccode.repository.IEnrollmentRepository;
import com.rrojase.retomitoccode.repository.IGenericRepository;
import com.rrojase.retomitoccode.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CRUDServiceImpl<Enrollment, Integer> implements IEnrollmentService {

    private final IEnrollmentRepository repository;

    @Override
    protected IGenericRepository<Enrollment, Integer> getRepository() {
        return repository;
    }
}
