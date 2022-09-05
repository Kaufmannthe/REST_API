package com.example.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FieldBridge;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.bridge.builtin.LongBridge;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "sensors")
@Entity
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "FieldHandler"})
@Indexed
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Field(name = "sensor_id")
    @FieldBridge(impl = LongBridge.class)
    private long id;

    @NotNull
    @Length(min = 1, max = 30)
    @Column(length = 30, nullable = false)
    @Field(name = "title")
    private String title;

    @NotNull
    @Length(min = 1, max = 30)
    @Column(length = 15, nullable = false)
    @Field(name = "model")
    private String model;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    private Range range;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Unit unit;

    @Length(min = 1, max = 40)
    @Column(length = 40)
    @Field(name = "location")
    private String location;

    @Length(min = 1, max = 200)
    @Column(length = 200, nullable = false)
    @Field(name = "description")
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
