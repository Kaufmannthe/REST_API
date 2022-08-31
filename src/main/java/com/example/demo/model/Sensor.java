package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Sensor {

    private int id;
    private String title;
    private String model;
    private String type;
    private String range;
    private String unit;
    private String location;

}
