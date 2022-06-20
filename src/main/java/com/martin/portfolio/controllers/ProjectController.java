package com.martin.portfolio.controllers;

import com.martin.portfolio.models.Project;
import com.martin.portfolio.payload.response.MessageResponse;
import com.martin.portfolio.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("/addProject")
    public ResponseEntity<?> addProject(@RequestBody Project project) {
        projectService.addProject(project);
        return MessageResponse.generateResponse("Item succesvol toegevoegd", HttpStatus.OK, null);
    }

    @GetMapping("/getProjects")
    @ResponseBody
    public Object getProjects() {
        try {
            return projectService.getAllProjects();
        } catch (Exception e) {
            return MessageResponse.generateResponse("An error has occurred: " + e, HttpStatus.BAD_REQUEST, null);
        }
    }
}
