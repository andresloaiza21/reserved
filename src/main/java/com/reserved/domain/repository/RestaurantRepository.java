package com.reserved.domain.repository;

import com.reserved.domain.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository {
    List<Restaurant> getAll();
    Optional<List<Restaurant>> getByType(int typeId);

    Optional<Restaurant> getRestaurant(int restaurantId);
    Optional<List<Restaurant>> getByAddress(String address);
    Optional<List<Restaurant>> getRestaurantByName(String name);
    Restaurant save(Restaurant restaurant);
    void delete(int restaurantID);
}
