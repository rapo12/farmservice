package com.uir.smartAgri.Controllers;

import com.uir.smartAgri.Entities.Sensor;
import com.uir.smartAgri.Services.SensorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sensorRes")
public class SensorController {
    private SensorService sensorservie;
    @GetMapping("all")
    public List<Sensor> getAllSensors(){
        return sensorservie.findAll();
    }
    @GetMapping("sensorbyfarm/{idfarm}")
    public List<Sensor> getAllSensorsByFarm(@PathVariable("idfarm") Long idfarm){
        return sensorservie.getSensorBelengsToFarm(idfarm);
    }
}