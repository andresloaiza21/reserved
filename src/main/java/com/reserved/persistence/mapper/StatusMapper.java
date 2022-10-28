package com.reserved.persistence.mapper;

import com.reserved.domain.Status;
import com.reserved.persistence.entity.Estado;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StatusMapper {

    @Mappings({
            @Mapping(source="idEstado", target = "statusId"),
            @Mapping(source="descripcion", target = "description"),
    })
    Status toStatus(Estado estado);

    @InheritInverseConfiguration
    Estado toEstado(Status status);
}
