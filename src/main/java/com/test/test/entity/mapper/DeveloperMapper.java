package com.test.test.entity.mapper;

import com.test.test.entity.DTO.DeveloperDTO;
import com.test.test.entity.Developer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeveloperMapper {
    DeveloperMapper instance = Mappers.getMapper(DeveloperMapper.class);

    DeveloperDTO toDto(Developer developer);

    List<DeveloperDTO> toDtos(List<Developer> developer);

    Developer toEntity(DeveloperDTO developerdto);



}
