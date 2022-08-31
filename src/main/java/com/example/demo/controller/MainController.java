package com.example.demo.controller;

import com.example.demo.model.Sensor;
import com.example.demo.service.SensorService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class MainController {
    private final SensorService service;

    @Autowired
    public MainController(SensorService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Sensor> allSensors() {
        return service.allSensors();
    }

    @PostMapping("/add")
    public void add(@RequestBody Sensor sensor) {
        service.save(sensor);
    }

    @PutMapping("/{id}")
    private void update(@PathVariable int id, @RequestBody Sensor sensor) {
        service.update(sensor);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable int id, @RequestBody Sensor sensor) {
        service.delete(sensor);
    }

}
