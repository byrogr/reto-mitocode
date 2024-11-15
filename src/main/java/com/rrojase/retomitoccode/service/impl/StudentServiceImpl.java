package com.rrojase.retomitoccode.service.impl;

import com.rrojase.retomitoccode.model.Student;
import com.rrojase.retomitoccode.repository.IGenericRepository;
import com.rrojase.retomitoccode.repository.IStudentRepository;
import com.rrojase.retomitoccode.service.ICRUDService;
import com.rrojase.retomitoccode.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDServiceImpl<Student, Integer> implements IStudentService {

    private final IStudentRepository repository;

    @Override
    protected IGenericRepository<Student, Integer> getRepository() {
        return repository;
    }
}
