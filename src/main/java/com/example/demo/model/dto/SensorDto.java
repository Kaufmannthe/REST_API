package com.example.demo.model.dto;

import com.example.demo.model.Type;
import com.example.demo.model.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SensorDto {

    private long id;
    private String title;
    private String model;
    private RangeDto range;
    private Type type;
    private Unit unit;
    private String location;
    private String description;

    public SensorDto(String title, String model, RangeDto range, Type type, Unit unit, String location, String description) {
        this.title = title;
        this.model = model;
        this.range = range;
        this.type = type;
        this.unit = unit;
        this.location = location;
        this.description = description;
    }

}
