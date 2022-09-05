package com.example.api.controller;

import com.example.api.model.Sensor;
import com.example.api.model.dto.SensorDto;
import com.example.api.service.SensorService;
import com.example.api.util.SensorConvertor;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
@OpenAPIDefinition(info = @Info(title = "REST Controller", version = "1.0", description = "REST API"))
public class RestController {
    private final SensorService service;

    @Autowired
    public RestController(SensorService service) {
        this.service = service;
    }

    @GetMapping("/sensors")
    @ResponseBody
    public List<Sensor> allSensors() {
        return service.allSensors();
    }

    @PreAuthorize("hasAuthority('Administrator')")
    @PostMapping("/admin/sensor")
    public Sensor add(@RequestBody SensorDto sensorDto) {
        Sensor sensor = SensorConvertor.convertToSensor(sensorDto);
        service.save(sensor);
        return sensor;
    }

    @PreAuthorize("hasAuthority('Administrator')")
    @PutMapping("/admin/sensor")
    public void update(@RequestBody SensorDto sensorDto) {
        Sensor sensor = SensorConvertor.sensorUpdate(sensorDto);
        service.update(sensor);
    }

    @PreAuthorize("hasAuthority('Administrator')")
    @DeleteMapping("/admin/sensor/{sensorId}")
    public void delete(@PathVariable long sensorId) {
        service.delete(sensorId);
    }

    @GetMapping("/search")
    @ResponseBody
    public List search(@RequestParam String text) throws InterruptedException {
        return service.search(text);
    }

}
