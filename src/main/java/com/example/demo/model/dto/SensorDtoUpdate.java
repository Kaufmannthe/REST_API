package com.example.demo.model.dto;

import com.example.demo.model.Type;
import com.example.demo.model.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorDtoUpdate {

    private long id;
    private String title;
    private String model;
    private RangeDto range;
    private Type type;
    private Unit unit;
    private String location;
    private String description;
}
