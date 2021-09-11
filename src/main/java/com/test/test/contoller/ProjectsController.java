package com.test.test.contoller;

import com.test.test.entity.DTO.ProjectDTO;
import com.test.test.entity.Project;
import com.test.test.entity.mapper.ProjectMapper;
import com.test.test.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/project")
@AllArgsConstructor
public class ProjectsController {
    private final ProjectRepository repo;
    private final ProjectMapper projectMapper;

    @PostMapping(path = "/post")
    public Project addNewProject(@RequestBody Project project) {
        repo.save(project);
        return project;
    }

    @DeleteMapping(path = "/delete/{id}")
    private Boolean deleteById(@PathVariable int id) {
        repo.deleteById(id);
        return !repo.existsById(id);
    }

    @GetMapping(path = "/get")
    private List<ProjectDTO> getAll(Project project) {

        return projectMapper.toDtos(repo.findAll());
    }
}
