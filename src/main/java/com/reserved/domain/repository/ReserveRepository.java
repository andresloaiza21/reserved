package com.reserved.domain.repository;

import com.reserved.domain.Reserve;
import com.reserved.domain.Restaurant;

import java.util.List;
import java.util.Optional;

public interface ReserveRepository {
    List<Reserve> getAll();

    Optional<List<Reserve>> getByStatus(int statusId);

    Optional<Reserve> getReserve(int reserveId);

    Reserve save(Reserve reserve);
    void delete(int reserveId);


}
