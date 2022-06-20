package com.martin.portfolio.services;

import com.martin.portfolio.DAO.CourseDAO;
import com.martin.portfolio.models.Book;
import com.martin.portfolio.models.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseDAO courseDAO;

    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }

    public void addCourse(Course course) {
        courseDAO.addCourse(course);
    }
}
