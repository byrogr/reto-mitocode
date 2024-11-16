package com.rrojase.retomitoccode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime enrollmentDate;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false, foreignKey = @ForeignKey(name = "FK_ENROLLMENT_STUDENT"))
    private Student student;

    @OneToMany(mappedBy = "enrollment", cascade = CascadeType.ALL)
    private List<EnrollmentDetail> enrollmentDetails;

    @JoinColumn(nullable = false)
    private boolean status;
}
