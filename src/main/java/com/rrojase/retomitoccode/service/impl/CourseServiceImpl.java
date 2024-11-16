package com.rrojase.retomitoccode.service.impl;

import com.rrojase.retomitoccode.model.Course;
import com.rrojase.retomitoccode.repository.ICourseRepository;
import com.rrojase.retomitoccode.repository.IGenericRepository;
import com.rrojase.retomitoccode.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDServiceImpl<Course, Integer> implements ICourseService {

    private final ICourseRepository repository;

    @Override
    protected IGenericRepository<Course, Integer> getRepository() {
        return repository;
    }
}
