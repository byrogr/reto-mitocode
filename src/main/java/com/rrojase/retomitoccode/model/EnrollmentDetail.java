package com.rrojase.retomitoccode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EnrollmentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "enrollment_id", nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_ENROLLMENT"))
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_COURSE"))
    private Course course;

    @Column(nullable = false)
    private String classroom;
}
