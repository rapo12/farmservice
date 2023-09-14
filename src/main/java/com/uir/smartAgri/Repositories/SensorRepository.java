package com.uir.smartAgri.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.uir.smartAgri.Entities.Sensor;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor,Long> {

}
