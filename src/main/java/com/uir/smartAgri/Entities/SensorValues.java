package com.uir.smartAgri.Entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;


@Entity
@AllArgsConstructor @NoArgsConstructor
@ToString
@Data
public class SensorValues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="IdSensor" ,nullable=false , referencedColumnName ="IdSensor")
    private Sensor sensor;

    @Column(name="date")
    @DateTimeFormat(pattern = "yyyy-mm-dd HH:mm")
    private Date date;

    @Column(name="value")
    private float value;


}