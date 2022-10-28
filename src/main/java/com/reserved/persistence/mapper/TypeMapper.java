package com.reserved.persistence.mapper;

import com.reserved.domain.Type;
import com.reserved.persistence.entity.Tipo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TypeMapper {
    @Mappings({
            @Mapping(source = "idTipo", target = "typeId"),
            @Mapping(source = "descripcion", target = "description"),
    })
    Type toType(Tipo tipo);

    @InheritInverseConfiguration
    @Mapping(target = "restaurantes", ignore = true)
    Tipo toTipo(Type type);
}
