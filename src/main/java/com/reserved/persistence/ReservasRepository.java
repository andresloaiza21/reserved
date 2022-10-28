package com.reserved.persistence;

import com.reserved.domain.Reserve;
import com.reserved.domain.Restaurant;
import com.reserved.domain.repository.ReserveRepository;
import com.reserved.persistence.crud.ReservaCrudRepository;
import com.reserved.persistence.entity.Reserva;
import com.reserved.persistence.mapper.ReserveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservasRepository implements ReserveRepository {

    @Autowired
    private ReservaCrudRepository reservaCrudRepository;
    @Autowired
    private ReserveMapper mapper;

    @Override
    public List<Reserve> getAll(){
        List<Reserva> reservas = (List<Reserva>) reservaCrudRepository.findAll();
        return mapper.toReserves(reservas);
    }

    @Override
    public Optional<List<Reserve>> getByStatus(int statusId) {
        List<Reserva> reservas = reservaCrudRepository.findByIdReserva(statusId);
        return Optional.of(mapper.toReserves(reservas));
    }

    @Override
    public Optional<Reserve> getReserve(int reserveId) {
        return reservaCrudRepository.findById(reserveId).map(reserva -> mapper.toReserve(reserva));
    }

    @Override
    public Reserve save(Reserve reserve) {
        Reserva reserva = mapper.toReserva(reserve);
        return mapper.toReserve(reservaCrudRepository.save(reserva));
    }

    @Override
    public void delete(int reserveId) {
        reservaCrudRepository.deleteById(reserveId);
    }

}
