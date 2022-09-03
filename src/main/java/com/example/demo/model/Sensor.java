package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "sensors")
@Entity
@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer","FieldHandler"})
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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    /*@JoinColumn(name = "range_id")*/
    private Range range;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private Unit unit;

    @Length(min = 1, max = 40)
    @Column(length = 40)
    private String location;

    @Length(min = 1, max = 200)
    @Column(length = 200, nullable = false)
    private String description;

    public Sensor(String title, String model, Range range, Type type, Unit unit, String location, String description) {
        this.title = title;
        this.model = model;
        this.range = range;
        this.type = type;
        this.unit = unit;
        this.location = location;
        this.description = description;
    }
}
