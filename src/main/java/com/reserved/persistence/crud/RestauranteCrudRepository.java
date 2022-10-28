package com.reserved.persistence.crud;

import com.reserved.persistence.entity.Restaurante;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestauranteCrudRepository extends CrudRepository<Restaurante, Integer> {

    List<Restaurante> findRestauranteByNombre(String nombre);

    Optional<List<Restaurante>> findByTipo(int tipo);

    Optional<List<Restaurante>> findByUbicacion(String ubicacion);
}
