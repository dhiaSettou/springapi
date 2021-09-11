package com.test.test.contoller;

import com.test.test.entity.DTO.DeveloperDTO;
import com.test.test.entity.Developer;
import com.test.test.entity.mapper.DeveloperMapper;
import com.test.test.repository.DeveloperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/developer")
@RequiredArgsConstructor
public class DeveloperController {
    private final DeveloperRepository repoTwo;
    private final DeveloperMapper developerMapper;

    @PostMapping(path = "/save")
    public Developer addNewProject(@RequestBody Developer developer){
        repoTwo.save(developer);
        return developer;
    }
    @DeleteMapping(path = "/delete/{id}")
    private Boolean deleteById(@PathVariable int id){
        repoTwo.deleteById(id);
        return !repoTwo.existsById(id);
    }
    @GetMapping(path = "/get")
    private List<DeveloperDTO> getAll(){
        return developerMapper.toDtos(repoTwo.findAll());
    }



@PatchMapping(path = "/update")
    private Developer update(@RequestBody Developer developer){
        if (repoTwo.existsById(developer.getId()))
         return repoTwo.save(developer);
        else {
            return null;
        }

    }

}
