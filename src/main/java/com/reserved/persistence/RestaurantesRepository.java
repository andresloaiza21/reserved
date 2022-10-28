package com.reserved.persistence;

import com.reserved.domain.Restaurant;
import com.reserved.domain.repository.RestaurantRepository;
import com.reserved.persistence.crud.RestauranteCrudRepository;
import com.reserved.persistence.entity.Restaurante;
import com.reserved.persistence.mapper.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RestaurantesRepository implements RestaurantRepository {
    @Autowired
    private RestauranteCrudRepository restauranteCrudRepository;
    @Autowired
    private RestaurantMapper mapper;

    @Override
    public List<Restaurant> getAll(){
        List<Restaurante> restaurantes = (List<Restaurante>) restauranteCrudRepository.findAll();
        return mapper.toRestaurants(restaurantes);
    }

    @Override
    public Optional<List<Restaurant>> getByType(int tipoId){
        Optional<List<Restaurante>> restaurantes = restauranteCrudRepository.findByTipo(tipoId);
        return restaurantes.map(restaurantes1 -> mapper.toRestaurants(restaurantes1));
    }

    @Override
    public Optional<Restaurant> getRestaurant(int restaurantId) {
        return restauranteCrudRepository.findById(restaurantId).map(restaurante -> mapper.toRestaurant(restaurante));
    }

    @Override
    public Optional<List<Restaurant>> getByAddress(String address) {
        return restauranteCrudRepository.findByUbicacion(address)
                .map(restaurantes -> mapper.toRestaurants(restaurantes));
    }

    @Override
    public Optional<List<Restaurant>> getRestaurantByName(String name) {
        List<Restaurante> restaurantes = restauranteCrudRepository.findRestauranteByNombre(name);
        return Optional.of(mapper.toRestaurants(restaurantes));
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        Restaurante restaurante = mapper.toRestaurante(restaurant);
        return mapper.toRestaurant(restaurante);
    }

    @Override
    public void delete(int idRestaurante){
        restauranteCrudRepository.deleteById(idRestaurante);
    }
}
