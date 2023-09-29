package com.uir.smartAgri.Services;

import com.uir.smartAgri.Entities.Sensor;

import java.util.List;

public interface SensorService {

    List<Sensor> findAll();
    List<Sensor> getSensorBelengsToFarm(Long id_farm);


}