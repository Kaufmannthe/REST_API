package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "FieldHandler"})
public class Range {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int rangeFrom;

    private int rangeTo;

    public Range(int rangeFrom, int rangeTo) {
        this.rangeTo = rangeTo;
        this.rangeFrom = rangeFrom;
    }

}
