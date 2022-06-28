package com.martin.portfolio.DAO;

import com.martin.portfolio.models.Project;
import com.martin.portfolio.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectDAO {

    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public void addProject(Project project) {
        projectRepository.save(project);
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}