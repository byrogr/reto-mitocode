package com.rrojase.retomitoccode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDetail {
    private Course course;
    private String classroom;
}
