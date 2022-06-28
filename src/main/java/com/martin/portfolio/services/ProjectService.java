package com.martin.portfolio.services;

import com.martin.portfolio.DAO.ProjectDAO;
import com.martin.portfolio.models.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectDAO projectDAO;

    public ProjectService(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public List<Project> getAllProjects() {
        return projectDAO.getAllProjects();
    }

    public void addProject(Project project) {
        projectDAO.addProject(project);
    }

    public void deleteProject(Long projectId) {
        projectDAO.deleteProject(projectId);
    }
}