package com.reserved.persistence.mapper;

import com.reserved.domain.Restaurant;
import com.reserved.persistence.entity.Restaurante;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper(componentModel = "spring", uses = {TypeMapper.class})
public interface RestaurantMapper {
    @Mappings({
            @Mapping(source="idRestaurante", target="restaurantId"),
            @Mapping(source="nombre", target="restaurantName"),
            @Mapping(source="direccion", target="address"),
            @Mapping(source="idTipo", target="typeId"),
            @Mapping(source="horario", target="schedule"),
            @Mapping(source="ubicacion", target="location"),
            @Mapping(source="tipo", target="type")

    })
    Restaurant toRestaurant(Restaurante restaurante);
    List<Restaurant> toRestaurants(List<Restaurante> restaurantes);

    @InheritInverseConfiguration
    @Mapping(target = "tipo", ignore = true)
    Restaurante toRestaurante(Restaurant restaurant);
}
