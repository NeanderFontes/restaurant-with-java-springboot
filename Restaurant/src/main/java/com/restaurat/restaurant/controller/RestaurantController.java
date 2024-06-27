package com.restaurat.restaurant.controller;

import com.restaurat.restaurant.DTO.RestaurantDTO;
import com.restaurat.restaurant.services.RestaurantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantServices services;

    @GetMapping(value = "/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public RestaurantDTO findById(@PathVariable(value = "id") Long id) {
        return services.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RestaurantDTO> findAll() {
        return services.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public RestaurantDTO create(@RequestBody RestaurantDTO addEntityDTO) {
        return services.create(addEntityDTO);
    }

    @PutMapping(value = "/{id}",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public RestaurantDTO update(@RequestBody RestaurantDTO updateEntityDTO) {
        return services.update(updateEntityDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long deleteEntityModel) {
        services.delete(deleteEntityModel);
        return ResponseEntity.noContent().build();
    }
}
