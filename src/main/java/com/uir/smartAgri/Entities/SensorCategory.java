package com.uir.smartAgri.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class SensorCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer IdCateg;
    private String Reference;
    private String Description;
}
