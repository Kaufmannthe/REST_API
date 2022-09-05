package com.example.api.service.impl;

import com.example.api.model.Sensor;
import com.example.api.repository.SensorRepository;
import com.example.api.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    private final SensorRepository repository;

    @Autowired
    public SensorServiceImpl(SensorRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public List<Sensor> allSensors() {
        return repository.allSensors();
    }

    @Override
    @Transactional
    public void update(Sensor sensor) {
        repository.update(sensor);
    }

    @Override
    @Transactional
    public void save(Sensor sensor) {
        repository.save(sensor);
    }

    @Override
    @Transactional
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    @Transactional
    public Sensor findById(long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public List search(String text) {
        return repository.search(text);
    }

}
