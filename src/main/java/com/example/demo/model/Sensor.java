package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "sensors")
@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Length(min = 1, max = 30)
    @Column(length = 30, nullable = false)
    private String title;

    @NotNull
    @Length(min = 1, max = 30)
    @Column(length = 15, nullable = false)
    private String model;

    @NotNull
    private Type type;

    private Unit unit;

    @Length(min = 1, max = 40)
    @Column(length = 40)
    private String location;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private Range range;

    @Length(min = 1, max = 200)
    @Column(length = 200, nullable = false)
    private String description;

    public Sensor(String title, String model, Type type, Unit unit, String location, Range range, String description) {
        this.title = title;
        this.model = model;
        this.type = type;
        this.unit = unit;
        this.location = location;
        this.range = range;
        this.description = description;
    }
}
