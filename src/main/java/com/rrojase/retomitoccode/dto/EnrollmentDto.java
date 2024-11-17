package com.rrojase.retomitoccode.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDto {

    private Integer id;

    @NotNull
    @JsonProperty(value = "fecha_matricula")
    private LocalDateTime enrollmentDate;

    @NotNull
    @JsonProperty(value = "estudiante")
    private StudentDto student;

    @NotNull
    @JsonProperty(value = "detalle_matricula")
    @JsonManagedReference
    private List<EnrollmentDetailDto> details;

    @NotNull
    @JsonProperty(value = "estado")
    private boolean status;
}
