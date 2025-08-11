package com.example.restaurant_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {


    private final RestaurantRepository restaurantRepository;


    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/getRestaurant")
    public List<Restaurant> getAllRestaurant(){
        System.out.println("aaa");
        return restaurantRepository.findAll();
    }

    ///use this when you want to test Fallback mechanism.
     /*  @GetMapping("/getRestaurant")
    public List<Restaurant> getAllRestaurant() {
        System.out.println("Simulating failure...");
        throw new RuntimeException("Simulated service failure");
    }*/


    @PostMapping("/addNewRestaurant")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant){
        if(restaurant.equals("abc")) {
            throw new RestaurantNotFoundException("not found ");
        }
        return restaurantRepository.save(restaurant);
    }
}
