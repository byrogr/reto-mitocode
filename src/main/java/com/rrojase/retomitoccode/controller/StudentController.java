package com.rrojase.retomitoccode.controller;

import com.rrojase.retomitoccode.model.Student;
import com.rrojase.retomitoccode.service.impl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServiceImpl service;

    public ResponseEntity<List<Student>> getAllStudents() throws Exception {
        List<Student> listOfStudents = service.findAll();
        return ResponseEntity.ok(listOfStudents);
    }
}
