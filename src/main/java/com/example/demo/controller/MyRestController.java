package com.example.demo.controller;

import com.example.demo.model.Range;
import com.example.demo.model.Sensor;
import com.example.demo.model.Type;
import com.example.demo.model.Unit;
import com.example.demo.model.dto.SensorDto;
import com.example.demo.service.SensorService;
import com.example.demo.util.SensorConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/test")
public class MyRestController {
    private final SensorService service;

    @Autowired
    public MyRestController(SensorService service) {
        this.service = service;
    }

    @GetMapping("/")
    @ResponseBody
    public Sensor getSensor() {
        return new Sensor("Artem", "Bohan", new Range(1, 10, 30), Type.HUMIDITY, Unit.BAR,
                "Minsk", "????");
    }



/*    @GetMapping("/")
    @ResponseBody
    public List<Sensor> allSensors() {
        return service.allSensors();
    }*/

/*    @GetMapping("/sensor/{id}")
    @ResponseBody
    public Sensor findById(@PathVariable long id){
        return service.findById(id);
    }*/

    @PostMapping("/add")
    public Sensor add(@RequestBody SensorDto sensorDto) {
        Sensor sensor = SensorConvertor.convertToSensor(sensorDto);
        service.save(sensor);;
        return sensor;
    }

    @PutMapping("/update/{id}")
    private void update(@PathVariable int id, @RequestBody Sensor sensor) {
        service.update(sensor);
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable int id, @RequestBody Sensor sensor) {
        service.delete(sensor);
    }

}
