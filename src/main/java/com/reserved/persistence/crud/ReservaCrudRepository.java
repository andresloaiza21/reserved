package com.reserved.persistence.crud;

import com.reserved.persistence.entity.Reserva;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReservaCrudRepository extends CrudRepository<Reserva, Integer> {
    List<Reserva> findByIdReserva(int idReserva);

    Optional<List<Reserva>> findReservaByEstado(int EstadoId);
}
