package com.example.demo.controller;

import com.example.demo.domain.City;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by thomasliao on 2017/6/21.
 */
@RestController
public class DemoController {

    @Autowired
    private CityService cityService;

    @RequestMapping("/demo")
    private String demo() {
        return "this is spring boot demo";
    }

    @RequestMapping("/info")
    private String info() {
        return "this is spring boot info";
    }

    @RequestMapping("/upload")
    private String upload() {
        return "this is spring boot upload";
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        return cityService.findCityByName(cityName);
    }

}
