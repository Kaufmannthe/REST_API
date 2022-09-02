package com.example.demo.util;

import com.example.demo.model.Range;
import com.example.demo.model.Sensor;
import com.example.demo.model.dto.SensorDto;
import com.example.demo.model.dto.SensorDtoUpdate;

public class SensorConvertor {
    public static Sensor convertToSensor(SensorDto sensorDto) {
        /*Range range = new Range(sensorDto.getRange().getFrom(), sensorDto.getRange().getTo());*/

        return new Sensor(sensorDto.getTitle(),
                sensorDto.getModel(),
                new Range(sensorDto.getRange().getFrom(), sensorDto.getRange().getTo()),
                sensorDto.getType(),
                sensorDto.getUnit(),
                sensorDto.getLocation(),
                sensorDto.getDescription());
    }

    public static Sensor convertToSensor(SensorDtoUpdate sensorDto) {
        /*Range range = new Range(sensorDto.getRange().getFrom(), sensorDto.getRange().getTo());*/

        return new Sensor(sensorDto.getTitle(),
                sensorDto.getModel(),
                new Range(sensorDto.getRange().getFrom(), sensorDto.getRange().getTo()),
                sensorDto.getType(),
                sensorDto.getUnit(),
                sensorDto.getLocation(),
                sensorDto.getDescription());
    }
}
