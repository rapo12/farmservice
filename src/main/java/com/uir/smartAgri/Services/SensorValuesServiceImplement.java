package com.uir.smartAgri.Services;

import com.uir.smartAgri.Entities.Sensor;
import com.uir.smartAgri.Entities.SensorValues;
import com.uir.smartAgri.Repositories.SensorRepository;
import com.uir.smartAgri.Repositories.SensorValuesRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class SensorValuesServiceImplement implements SensorValuesService{
    SensorValuesRepository sensorValuesRepository;

    @Override
    public List<Object> getInformationAboutSensorValueOfFarmByDate(int id_sensor,String startdate,String enddate){
        startdate+=" 00:00";
        enddate+=" 59:59";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date datestart = dateFormat.parse(startdate);
            Date dateend = dateFormat.parse(enddate);
            return sensorValuesRepository.getAllInformationsByIdAndDateV2(datestart,dateend,id_sensor);

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Object> getInformationAboutSensorValueOfFarmByDateV2() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startDate = dateFormat.parse("2023-09-15 00:00");
        Date ensdate = dateFormat.parse("2023-09-28 23:59");
        return sensorValuesRepository.getAllInformationsByIdAndDateV2(startDate,ensdate,1);
    }
}