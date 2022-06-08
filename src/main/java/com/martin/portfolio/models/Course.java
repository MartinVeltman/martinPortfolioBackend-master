package com.martin.portfolio.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String title;

    private String imagePath;

    private String instructor;

    private String description;

    private String review;

    private String yearOfAchievement;
}
