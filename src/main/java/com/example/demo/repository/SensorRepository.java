package com.example.demo.repository;

import com.example.demo.model.Sensor;

import java.util.List;

public interface SensorRepository {

    List<Sensor> allSensors();

    void update(Sensor sensor);

    void save(Sensor sensor);

    void delete(Sensor sensor);
}
