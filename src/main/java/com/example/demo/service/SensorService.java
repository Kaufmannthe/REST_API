package com.example.demo.service;

import com.example.demo.model.Sensor;

import java.util.List;

public interface SensorService {

    List<Sensor> allSensors();

    void update(Sensor sensor);

    void save(Sensor sensor);

    void delete(long id);
    Sensor findById(long id);
}
