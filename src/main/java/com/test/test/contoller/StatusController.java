package com.test.test.contoller;

import com.test.test.entity.DTO.StatusDTO;
import com.test.test.entity.Status;
import com.test.test.entity.Status;
import com.test.test.entity.mapper.StatusMapper;
import com.test.test.repository.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Status")
@AllArgsConstructor
public class StatusController {
    private final StatusRepository repo;
    private final StatusMapper statusMapper;

    @PostMapping(path = "/post")
    public Status addNewStatus(@RequestBody Status project) {
        repo.save(project);
        return project;
    }

    @DeleteMapping(path = "/delete/{id}")
    private Boolean deleteById(@PathVariable int id) {
        repo.deleteById(id);
        return !repo.existsById(id);
    }

    @GetMapping(path = "/get")
    private List<StatusDTO> getAll() {

        return statusMapper.toDtos(repo.findAll());
    }

}
