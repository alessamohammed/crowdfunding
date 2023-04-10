package com.example.crowdfunding.controller;

import com.example.crowdfunding.model.Project;
import com.example.crowdfunding.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class MainController {

    @Autowired
    private ProjectRepo ProjectRepo;

    public MainController(ProjectRepo ProjectRepo) {
        this.ProjectRepo = ProjectRepo;
    }

    @PostMapping("/add")
    // add project takes name and description
    public String addProject(@RequestParam String name, @RequestParam String description) {
        Project project = new Project();
        project.setName(name);
        project.setDescription(description);
        ProjectRepo.save(project);
        return "Saved";
    }

    @PostMapping("/delete")
    public String deleteProject(@RequestParam Integer id) {
        ProjectRepo.deleteById(id);
        return "Deleted";
    }

    @PostMapping("/update")
    public String updateProject(@RequestParam Integer id, @RequestParam String name, @RequestParam String description) {
        Project project = new Project();
        project.setId(id);
        project.setName(name);
        project.setDescription(description);
        ProjectRepo.save(project);
        return "Updated";
    }

    @GetMapping("/get")
    public String getProject(@RequestParam Integer id) {
        Project project = ProjectRepo.findById(id).orElse(null);
        return project.toString();
    }

    @GetMapping("/getall")
    public String getAllProjects() {
        return ProjectRepo.findAll().toString();
    }

}
