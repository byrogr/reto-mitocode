package com.rrojase.retomitoccode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {
    private LocalDateTime enrollmentDate;
    private Student student;
    private List<EnrollmentDetail> enrollmentDetails;
    private boolean status;
}
