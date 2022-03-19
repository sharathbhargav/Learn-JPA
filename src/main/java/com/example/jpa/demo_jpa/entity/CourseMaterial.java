package com.example.jpa.demo_jpa.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseMaterial {
    @Id
    @SequenceGenerator(name = "course_material_sequence", sequenceName =
            "course_material_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_material_sequence")
    Long courseMaterialId;
    String url;

    @OneToOne
    @JoinColumn(name = "course_id",referencedColumnName = "courseId")
    private Course course;
}
