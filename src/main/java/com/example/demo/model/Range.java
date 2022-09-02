package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Range{
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
