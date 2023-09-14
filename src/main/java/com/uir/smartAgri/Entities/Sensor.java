package com.uir.smartAgri.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Sensor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdSensor;
    private String unit;
    private int frequency;
    private Date timestamp;
    private float value;
    @ManyToOne
    private SensorCategory SensorCategory;
    @ManyToOne
    private Farm Farm;
}
