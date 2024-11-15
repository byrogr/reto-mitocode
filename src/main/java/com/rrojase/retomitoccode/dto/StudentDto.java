package com.rrojase.retomitoccode.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Integer id;

    @NotNull
    @JsonProperty(value = "nombres")
    private String name;

    @NotNull
    @JsonProperty(value = "apellidos")
    private String lastName;

    @NotNull
    @Size(min = 8, max = 8)
    @JsonProperty
    private String dni;

    @JsonProperty(value = "edad")
    @NotNull
    private int age;
}
