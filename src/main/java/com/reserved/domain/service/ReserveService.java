package com.reserved.domain.service;


import com.reserved.domain.Reserve;
import com.reserved.domain.repository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReserveService {
    @Autowired
    private ReserveRepository reserveRepository;

    public List<Reserve> getAll(){
        return reserveRepository.getAll();
    }

    public Optional<List<Reserve>> getByStatus(int statusId){
        return reserveRepository.getByStatus(statusId);
    }

    public Reserve save(Reserve reserve){
        return reserveRepository.save(reserve);
    }

    public Optional<Reserve> getReserve(int reserveId){
        return reserveRepository.getReserve(reserveId);
    }

    public boolean delete(int idReserve){
        return getReserve(idReserve).map(reserve -> {
            reserveRepository.delete(idReserve);
            return true;
        }).orElse(false);
    }
}
