package com.example.demo.dao;

import com.example.demo.domain.City;
import org.apache.ibatis.annotations.Param;

/**
 * Created by thomasliao on 2017/8/15.
 * DAO(Data Access Object) 数据访问对象是一个面向对象的数据库接口
 */
public interface CityDao {

    City findByName(@Param("cityName") String cityName);

}
