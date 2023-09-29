package com.uir.smartAgri.Services;

import com.uir.smartAgri.Entities.Sensor;
import com.uir.smartAgri.Repositories.SensorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class SensorServiceImplement implements SensorService {

    private SensorRepository sensorRepository;
    @Override
    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    @Override
    public List<Sensor> getSensorBelengsToFarm(Long id_farm) {
        return sensorRepository.findSensorBelongsToFarmById(id_farm);
    }


}