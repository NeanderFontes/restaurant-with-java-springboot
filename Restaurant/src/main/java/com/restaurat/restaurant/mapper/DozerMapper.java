package com.restaurat.restaurant.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <RestaurantModel, RestaurantDTO> RestaurantDTO parseObject(RestaurantModel origin, Class<RestaurantDTO> destination) {
        return mapper.map(origin, destination);
    }

    public static <RestaurantModel, RestaurantDTO> List<RestaurantDTO> parseListObject(List<RestaurantModel> origin, Class<RestaurantDTO> restaurantDTOClass) {
        List<RestaurantDTO> destinationObjects = new ArrayList<RestaurantDTO>();
        for (RestaurantModel objectModel : origin) {
            destinationObjects.add(mapper.map(objectModel, restaurantDTOClass));
        }
        return destinationObjects;
    }
}
