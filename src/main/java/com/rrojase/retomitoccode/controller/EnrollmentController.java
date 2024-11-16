package com.rrojase.retomitoccode.controller;

import com.rrojase.retomitoccode.dto.EnrollmentDto;
import com.rrojase.retomitoccode.dto.GenericResponse;
import com.rrojase.retomitoccode.dto.StudentDto;
import com.rrojase.retomitoccode.model.Enrollment;
import com.rrojase.retomitoccode.model.Student;
import com.rrojase.retomitoccode.service.IEnrollmentService;
import com.rrojase.retomitoccode.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final IEnrollmentService service;
    private final MapperUtil mapper;

    @GetMapping
    public ResponseEntity<GenericResponse<EnrollmentDto>> getAllEnrollments() throws Exception {
        List<EnrollmentDto> listOfEnrollments = mapper.toList(service.findAll(), EnrollmentDto.class);

        GenericResponse<EnrollmentDto> response = new GenericResponse<>(
                HttpStatus.OK.value(),
                "success",
                listOfEnrollments
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<GenericResponse<EnrollmentDto>> createEnrollment(@Valid @RequestBody EnrollmentDto enrollmentDto) throws Exception {
        Enrollment enrollment = service.save(mapper.toMap(enrollmentDto, Enrollment.class));
        List<EnrollmentDto> enrollmentCreated = Arrays.asList(mapper.toMap(enrollment, EnrollmentDto.class));
        GenericResponse<EnrollmentDto> response = new GenericResponse<>(
                HttpStatus.CREATED.value(),
                "success",
                enrollmentCreated
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
