package com.reserved.domain.service;

import com.reserved.domain.Restaurant;
import com.reserved.domain.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAll(){
        return restaurantRepository.getAll();
    }

    public Optional<Restaurant> getRestaurant(int restaurantId){
        return restaurantRepository.getRestaurant(restaurantId);
    }

    public Optional<List<Restaurant>> getByType(int typeId){
        return restaurantRepository.getByType(typeId);
    }

    public Restaurant save(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    public boolean delete(int restaurantId){
        return getRestaurant(restaurantId).map(restaurant -> {
            restaurantRepository.delete(restaurantId);
            return true;
        }).orElse(false);
    }
}
