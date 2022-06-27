package com.martin.portfolio.controllers;

import com.martin.portfolio.models.Book;
import com.martin.portfolio.models.Course;
import com.martin.portfolio.payload.response.MessageResponse;
import com.martin.portfolio.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/addCourse")
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        System.out.println(course.getImagePath());
        courseService.addCourse(course);
        return MessageResponse.generateResponse("Item succesvol toegevoegd", HttpStatus.OK, null);
    }

    @GetMapping("/getCourses")
    @ResponseBody
    public Object getBooks() {
        try {
            return courseService.getAllCourses();
        } catch (Exception e) {
            return MessageResponse.generateResponse("An error has occurred: " + e, HttpStatus.BAD_REQUEST, null);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourseById(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return MessageResponse.generateResponse("Item succesvol verwijderd", HttpStatus.OK, null);
    }

}
