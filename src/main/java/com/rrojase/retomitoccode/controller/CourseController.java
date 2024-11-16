package com.rrojase.retomitoccode.controller;

import com.rrojase.retomitoccode.dto.CourseDto;
import com.rrojase.retomitoccode.dto.GenericResponse;
import com.rrojase.retomitoccode.dto.StudentDto;
import com.rrojase.retomitoccode.model.Course;
import com.rrojase.retomitoccode.model.Student;
import com.rrojase.retomitoccode.service.ICourseService;
import com.rrojase.retomitoccode.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService service;
    private final MapperUtil mapper;

    @GetMapping
    public ResponseEntity<GenericResponse<CourseDto>> getAllCourses() throws Exception {
        List<CourseDto> listOfCourses = mapper.toList(service.findAll(), CourseDto.class);
        GenericResponse<CourseDto> response = new GenericResponse<>(
                HttpStatus.OK.value(),
                "success",
                listOfCourses
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CourseDto>> getCourseById(@PathVariable("id") Integer id) throws Exception {
        List<CourseDto> courseObtain = Arrays.asList(mapper.toMap(service.findById(id), CourseDto.class));
        GenericResponse<CourseDto> response = new GenericResponse<>(
                HttpStatus.OK.value(),
                "success",
                courseObtain
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericResponse<CourseDto>> createCourse(@Valid @RequestBody CourseDto courseDto) throws Exception {
        Course course = service.save(mapper.toMap(courseDto, Course.class));
        List<CourseDto> courseCreated = Arrays.asList(mapper.toMap(course, CourseDto.class));
        GenericResponse<CourseDto> response = new GenericResponse<>(
                HttpStatus.CREATED.value(),
                "success",
                courseCreated
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<CourseDto>> updateStudent(@PathVariable("id") Integer id, @Valid @RequestBody CourseDto courseDto) throws Exception {
        courseDto.setId(id);
        Course course = service.save(mapper.toMap(courseDto, Course.class));
        List<CourseDto> courseUpdated = Arrays.asList(mapper.toMap(course, CourseDto.class));
        GenericResponse<CourseDto> response = new GenericResponse<>(
                HttpStatus.ACCEPTED.value(),
                "success",
                courseUpdated
        );
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<Void>> deleteStudent(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        GenericResponse<Void> response = new GenericResponse<>(
                HttpStatus.NO_CONTENT.value(),
                "success",
                null
        );
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}
