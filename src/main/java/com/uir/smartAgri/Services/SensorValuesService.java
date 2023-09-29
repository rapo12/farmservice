package com.uir.smartAgri.Services;

import com.uir.smartAgri.Entities.Sensor;
import com.uir.smartAgri.Entities.SensorValues;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface SensorValuesService {
    List<Object> getInformationAboutSensorValueOfFarmByDate(int id_sensor, String startdate, String enddate) ;
    List<Object> getInformationAboutSensorValueOfFarmByDateV2() throws ParseException;

}
