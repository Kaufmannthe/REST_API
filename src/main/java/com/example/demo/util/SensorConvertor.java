package com.example.demo.util;

import com.example.demo.model.Range;
import com.example.demo.model.Sensor;
import com.example.demo.model.dto.SensorDto;

public  class SensorConvertor {
    public static Sensor convertToSensor(SensorDto sensorDto){
        Range range = new Range(sensorDto.getRange().getTo(),sensorDto.getRange().getFrom());
        return new Sensor(sensorDto.getTitle(),sensorDto.getModel(),sensorDto.getType(),sensorDto.getUnit()
        ,sensorDto.getLocation(),new Range(range.getRangeTo(), range.getRangeFrom()),sensorDto.getDescription());
    }
}
