package com.reserved.web.controller;

import com.reserved.domain.Reserve;
import com.reserved.domain.Restaurant;
import com.reserved.domain.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/all")
    public List<Restaurant> getAll(){
        return restaurantService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Restaurant> getReserve(@PathVariable("id") int restaurantId){
        return restaurantService.getRestaurant(restaurantId);
    }

    @GetMapping("/type/{typeId}")
    public Optional<List<Restaurant>> getByType(@PathVariable("typeId") int typeId){
        return restaurantService.getByType(typeId);
    }
    @PostMapping("/save")
    public Restaurant save(Restaurant restaurant){
        return restaurantService.save(restaurant);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int restaurantId){
        return restaurantService.delete(restaurantId);
    }
}
