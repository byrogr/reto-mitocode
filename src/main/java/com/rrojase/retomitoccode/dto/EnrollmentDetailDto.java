package com.rrojase.retomitoccode.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDetailDto {
    private Integer id;

    @JsonBackReference
    private EnrollmentDto enrollment;

    @NotNull
    @JsonProperty(value = "curso")
    private CourseDto course;

    @NotNull
    @JsonProperty(value = "aula")
    private String classroom;
}
