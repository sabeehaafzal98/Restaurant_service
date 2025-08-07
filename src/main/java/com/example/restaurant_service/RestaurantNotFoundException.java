package com.example.restaurant_service;

public class RestaurantNotFoundException extends RuntimeException{

    public RestaurantNotFoundException(String msg){
       super(msg);
    }
}
