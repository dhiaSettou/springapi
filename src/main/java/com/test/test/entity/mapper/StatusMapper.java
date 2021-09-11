package com.test.test.entity.mapper;

import com.test.test.entity.DTO.StatusDTO;
import com.test.test.entity.Status;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    StatusMapper instance = Mappers.getMapper(StatusMapper.class);

    StatusDTO toDto(Status status);

    List<StatusDTO> toDtos(List<Status> statuses);

    Status toEntity(StatusDTO statusdto);
}
