package com.restaurat.restaurant.repositories;

import com.restaurat.restaurant.model.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantModel, Long> {
}
