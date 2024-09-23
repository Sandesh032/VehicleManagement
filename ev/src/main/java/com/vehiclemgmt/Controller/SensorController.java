package com.vehiclemgmt.Controller;

import com.vehiclemgmt.DTO.SensorDTO;
import com.vehiclemgmt.Model.Sensor;
import com.vehiclemgmt.Model.Vehicles;
import com.vehiclemgmt.Service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SensorController {
    @Autowired
    SensorService sensorService;

    @GetMapping("/getSensors")
    public List<Sensor> getSensors() {
        return sensorService.getSensor();
    }

    @GetMapping("/sensor_anomalies")
    public List<Vehicles> detectAnomalies() {
        return sensorService.detectAnomalies();
    }

    @PostMapping("/insertSensor")
    public String insertSensor(@RequestBody SensorDTO sensorDTO) {
        sensorService.insertSensor(sensorDTO);
        return "Sensors added successfully!!";
    }

    @PostMapping("/insertSensors")
    public String insertSensor(@RequestBody List<SensorDTO> sensorDTO) {
        sensorService.insertSensors(sensorDTO);
        return "Sensors added successfully!!";
    }
}