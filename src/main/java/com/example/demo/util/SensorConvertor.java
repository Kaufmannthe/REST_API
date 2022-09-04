package com.example.demo.util;

import com.example.demo.model.Range;
import com.example.demo.model.Sensor;
import com.example.demo.model.dto.SensorDto;

public class SensorConvertor {
    public static Sensor convertToSensor(SensorDto sensorDto) {
        Range range = new Range(sensorDto.getRange().getRangeFrom(), sensorDto.getRange().getRangeTo());

        return new Sensor(sensorDto.getTitle(),
                sensorDto.getModel(),
                new Range(range.getRangeFrom(), range.getRangeTo()),
                sensorDto.getType(),
                sensorDto.getUnit(),
                sensorDto.getLocation(),
                sensorDto.getDescription());
    }

    public static Sensor sensorUpdate(SensorDto sensor) {

        return new Sensor(sensor.getId(),
                sensor.getTitle(),
                sensor.getModel(),
                new Range(sensor.getRange().getId(), sensor.getRange().getRangeFrom(), sensor.getRange().getRangeTo()),
                sensor.getType(),
                sensor.getUnit(),
                sensor.getLocation(),
                sensor.getDescription());

    }
}
