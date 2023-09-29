package com.uir.smartAgri.Entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Sensor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdSensor;
    @NotNull
    @Size(min=1, message=" is required")
    private String unit;
    private int frequency;
    @DateTimeFormat(pattern = "yyyy-mm-dd'T'HH:mm")
    private Date timestamp;
    @ManyToOne
    private SensorCategory SensorCategory;
    @ManyToOne
    private Farm Farm;
}
