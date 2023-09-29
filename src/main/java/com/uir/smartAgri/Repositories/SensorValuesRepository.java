package com.uir.smartAgri.Repositories;

import com.uir.smartAgri.Entities.Sensor;
import com.uir.smartAgri.Entities.SensorValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface SensorValuesRepository extends JpaRepository<SensorValues,Long> {
    @Query("select sv from SensorValues sv where sv.date>=:startdate and sv.date<=:enddate and sv.sensor.IdSensor=:idsensor")
    List<Object> getAllInformationsByIdAndDate(String startdate,String enddate,int idsensor);


    @Query("select sv from SensorValues sv where sv.date>=:startdate and sv.date<=:enddate and sv.sensor.IdSensor=:idsensor")
    List<Object> getAllInformationsByIdAndDateV2(Date startdate, Date enddate, int idsensor);

}

