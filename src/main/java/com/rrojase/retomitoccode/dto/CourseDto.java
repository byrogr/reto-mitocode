package com.rrojase.retomitoccode.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private Integer id;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 50)
    @JsonProperty(value = "nombre")
    private String name;

    @NotNull
    @Size(min = 1, max = 5)
    @JsonProperty(value = "siglas")
    private String acronym;

    @NotNull
    @JsonProperty(value = "estado")
    private boolean status;
}
