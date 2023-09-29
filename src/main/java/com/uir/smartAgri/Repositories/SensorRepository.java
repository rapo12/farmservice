package com.uir.smartAgri.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.uir.smartAgri.Entities.Sensor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor,Long> {
    @Query("select s from Sensor s where s.Farm.idFarm=:idFarm")
    List<Sensor> findSensorBelongsToFarmById(Long idFarm);


}
