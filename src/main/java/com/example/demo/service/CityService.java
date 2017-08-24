package com.example.demo.service;

import com.example.demo.domain.City;

/**
 * Created by thomasliao on 2017/8/15.
 */
public interface CityService {

    City findCityByName(String cityName);

}
