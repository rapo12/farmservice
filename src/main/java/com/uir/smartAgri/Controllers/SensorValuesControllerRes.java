package com.uir.smartAgri.Controllers;

import com.uir.smartAgri.Entities.Sensor;
import com.uir.smartAgri.Entities.SensorValues;
import com.uir.smartAgri.Services.FarmService;
import com.uir.smartAgri.Services.SensorService;
import com.uir.smartAgri.Services.SensorValuesService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/farm")
public class SensorValuesControllerRes {
    SensorValuesService sensorValuesService;
    @GetMapping("/data")
    public List<Object> getdata( @RequestParam("id") int id_sensor, @RequestParam("start") String startdate,
                                 @RequestParam("end") String enddate) {

        return sensorValuesService.getInformationAboutSensorValueOfFarmByDate(id_sensor,startdate,enddate);
    }

    @GetMapping("/data2")
    public List<Object> getdataV2() throws ParseException {
        return sensorValuesService.getInformationAboutSensorValueOfFarmByDateV2();
    }
}