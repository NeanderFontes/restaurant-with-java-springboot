package com.restaurat.restaurant.services;

import com.restaurat.restaurant.DTO.RestaurantDTO;
import com.restaurat.restaurant.mapper.DozerMapper;
import com.restaurat.restaurant.model.RestaurantModel;
import com.restaurat.restaurant.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServices {
    @Autowired
    RestaurantRepository restaurantRepository;

    public RestaurantDTO findById(Long findItemById) {
        RestaurantModel entityModel = restaurantRepository.findById(findItemById).orElseThrow();
        return DozerMapper.parseObject(entityModel, RestaurantDTO.class);
    }

    public List<RestaurantDTO> findAll() {
        return DozerMapper.parseListObject(restaurantRepository.findAll(), RestaurantDTO.class);
    }

    public RestaurantDTO create(RestaurantDTO addEntityDTO) {
        RestaurantModel entityModel = DozerMapper.parseObject(addEntityDTO, RestaurantModel.class);
        RestaurantDTO auxEntityDTO = DozerMapper.parseObject(restaurantRepository.save(entityModel), RestaurantDTO.class);
        return auxEntityDTO;
    }

    public RestaurantDTO update(RestaurantDTO updateEntityDTO) {
        RestaurantModel entityUpdateRestaurantModel = restaurantRepository.findById(updateEntityDTO.getId()).orElseThrow();

        entityUpdateRestaurantModel.setName(updateEntityDTO.getName());
        entityUpdateRestaurantModel.setPrice(updateEntityDTO.getPrice());

        RestaurantDTO entityDTO = DozerMapper.parseObject(restaurantRepository.save(entityUpdateRestaurantModel), RestaurantDTO.class);
        return entityDTO;
    }

    public void delete(Long deleteEntityModel) {
        RestaurantModel entityDeleteModel = restaurantRepository.findById(deleteEntityModel).orElseThrow();
        restaurantRepository.delete(entityDeleteModel);
    }
}
