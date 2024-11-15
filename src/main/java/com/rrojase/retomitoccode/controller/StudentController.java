package com.rrojase.retomitoccode.controller;

import com.rrojase.retomitoccode.dto.GenericResponse;
import com.rrojase.retomitoccode.dto.StudentDto;
import com.rrojase.retomitoccode.model.Student;
import com.rrojase.retomitoccode.service.impl.StudentServiceImpl;
import com.rrojase.retomitoccode.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServiceImpl service;
    private final MapperUtil mapper;

    @GetMapping
    public ResponseEntity<GenericResponse<StudentDto>> getAllStudents() throws Exception {
        List<StudentDto> listOfStudents = mapper.toList(service.findAll(), StudentDto.class);
        GenericResponse<StudentDto> response = new GenericResponse<>(
                HttpStatus.OK.value(),
                "success",
                listOfStudents
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<StudentDto>> getStudentById(@PathVariable("id") Integer id) throws Exception {
        List<StudentDto> studentObtain = Arrays.asList(mapper.toMap(service.findById(id), StudentDto.class));
        GenericResponse<StudentDto> response = new GenericResponse<>(
                HttpStatus.OK.value(),
                "success",
                studentObtain
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericResponse<StudentDto>> createStudent(@RequestBody StudentDto studentDto) throws Exception {
        Student student = service.save(mapper.toMap(studentDto, Student.class));
        List<StudentDto> studentCreated = Arrays.asList(mapper.toMap(student, StudentDto.class));
        GenericResponse<StudentDto> response = new GenericResponse<>(
                HttpStatus.CREATED.value(),
                "success",
                studentCreated
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
