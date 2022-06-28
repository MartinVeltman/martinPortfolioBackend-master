package com.martin.portfolio.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @Column
    private String imageUrl;

    @Column
    private String instructor;

    @Column
    private String description;

    @Column
    private String courseLink;

    @Column
    private Integer yearOfAchievement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseLink() {
        return courseLink;
    }

    public void setCourseLink(String courseLink) {
        this.courseLink = courseLink;
    }

    public Integer getYearOfAchievement() {
        return yearOfAchievement;
    }

    public void setYearOfAchievement(Integer yearOfAchievement) {
        this.yearOfAchievement = yearOfAchievement;
    }
}
