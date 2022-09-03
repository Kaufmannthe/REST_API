package com.example.demo.service.impl;

import com.example.demo.model.Sensor;
import com.example.demo.repository.SensorRepository;
import com.example.demo.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    private final SensorRepository repository;

    @Autowired
    public SensorServiceImpl(SensorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Sensor> allSensors() {
        return repository.allSensors();
    }

    @Override
    public void update(Sensor sensor) {
        repository.update(sensor);
    }

    @Override
    public void save(Sensor sensor) {
        repository.save(sensor);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public Sensor findById(long id) {
        return repository.findById(id);
    }
}
