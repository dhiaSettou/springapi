package com.test.test.entity.mapper;

import com.test.test.entity.DTO.DeveloperDTO;
import com.test.test.entity.DTO.ProjectDTO;
import com.test.test.entity.Developer;
import com.test.test.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectMapper instance = Mappers.getMapper(ProjectMapper.class);


    @Mapping(source = "developers",target = "developers", qualifiedByName = "toDeveloperDto")
    ProjectDTO toDto(Project project);

    List<ProjectDTO> toDtos(List<Project> projects);


    Project toEntity(ProjectDTO projectdto);

    @Named("toDeveloperDto")
    static DeveloperDTO toDeveloperDto(Developer developer){
        return DeveloperMapper.instance.toDto(developer);
    }

}
