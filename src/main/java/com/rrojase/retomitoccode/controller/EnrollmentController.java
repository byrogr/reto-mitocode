package com.rrojase.retomitoccode.controller;

import com.rrojase.retomitoccode.dto.*;
import com.rrojase.retomitoccode.model.Enrollment;
import com.rrojase.retomitoccode.model.EnrollmentDetail;
import com.rrojase.retomitoccode.model.Student;
import com.rrojase.retomitoccode.service.IEnrollmentService;
import com.rrojase.retomitoccode.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

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

    @GetMapping("/related/courses")
    public ResponseEntity<Map<String, List<String>>> getEnrollmentCourses() throws Exception {
        List<EnrollmentDetail> list = service.findAll()
                .stream()
                .map(Enrollment::getEnrollmentDetails)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        Map<String, List<String>> enrollmentCoursesRelatedStudents = list
                .stream()
                .collect(
                        Collectors.groupingBy(
                                (EnrollmentDetail e) -> e.getCourse().getName(),
                                Collectors.mapping(
                                        (EnrollmentDetail e) -> e.getEnrollment().getStudent().getName() + " " + e.getEnrollment().getStudent().getLastName(),
                                        Collectors.toList()
                                )
                        )
                );

        return new ResponseEntity<>(enrollmentCoursesRelatedStudents, HttpStatus.OK);
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
