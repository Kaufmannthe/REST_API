package com.example.demo.controller;

import com.example.demo.model.Sensor;
import com.example.demo.model.dto.SensorDto;
import com.example.demo.service.SensorService;
import com.example.demo.util.SensorConvertor;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/test")
@OpenAPIDefinition(info = @Info(title = "Rest Controller", version = "1.0", description = "Rest API"))
public class MyRestController {
    private final SensorService service;

    @Autowired
    public MyRestController(SensorService service) {
        this.service = service;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Sensor> allSensors() {
        return service.allSensors();
    }

    @PreAuthorize("hasAuthority('Administrator')")
    @PostMapping("/admin/add")
    public Sensor add(@RequestBody SensorDto sensorDto) {
        Sensor sensor = SensorConvertor.convertToSensor(sensorDto);
        service.save(sensor);
        return sensor;
    }

    @PreAuthorize("hasAuthority('Administrator')")
    @PutMapping("/admin/update")
    public Sensor update(@RequestBody SensorDto sensorDto) {
        Sensor sensor = SensorConvertor.sensorUpdate(sensorDto);
        service.update(sensor);
        return sensor;
    }

    @PreAuthorize("hasAuthority('Administrator')")
    @DeleteMapping("/admin/delete/{id}")
    public long delete(@PathVariable long id) {
        service.delete(id);
        return id;
    }

    @GetMapping("/search")
    @ResponseBody
    public List search(@RequestParam String text) throws InterruptedException {
        return service.search(text);
    }

}
