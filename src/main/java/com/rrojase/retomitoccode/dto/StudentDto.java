package com.rrojase.retomitoccode.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDto {
    private Integer id;

    @NotNull
    @NotBlank
    @NotEmpty
    @JsonProperty(value = "nombres")
    private String name;

    @NotNull
    @NotBlank
    @NotEmpty
    @JsonProperty(value = "apellidos")
    private String lastName;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 8, max = 8)
    @JsonProperty
    private String dni;

    @JsonProperty(value = "edad")
    @NotNull
    private int age;
}
