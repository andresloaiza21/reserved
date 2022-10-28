package com.reserved.persistence.mapper;

import com.reserved.domain.Reserve;
import com.reserved.persistence.entity.Reserva;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper(componentModel = "spring", uses = {StatusMapper.class, RestaurantMapper.class})
public interface ReserveMapper {
    @Mappings({
            @Mapping(source = "idReserva", target = "reserveId"),
            @Mapping(source = "idEstado", target = "statusId"),
            @Mapping(source = "idRestaurante", target = "restaurantId"),
            @Mapping(source = "numeroComensales", target = "guestNumber"),
            @Mapping(source = "fecha", target = "date"),
           // @Mapping(source = "time", target = "time"),
            @Mapping(source = "decoracion", target = "decoration"),
            @Mapping(source = "nota", target = "note"),
            @Mapping(source = "estado", target = "status"),
            @Mapping(source = "restaurante", target = "restaurant"),
    })
    Reserve toReserve(Reserva reserva);
    List<Reserve> toReserves(List<Reserva> reservas);

    @InheritInverseConfiguration
    Reserva toReserva(Reserve reserve);


}
