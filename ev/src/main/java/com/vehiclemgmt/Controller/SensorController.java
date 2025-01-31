package com.vehiclemgmt.Controller;

import com.vehiclemgmt.DTO.SensorDTO;
import com.vehiclemgmt.Model.Sensor;
import com.vehiclemgmt.Model.Vehicles;
import com.vehiclemgmt.Service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SensorController {
    @Autowired
    SensorService sensorService;

    @GetMapping("/sensor/{id}")
    public Sensor getSensor(@PathVariable int id) {
        return sensorService.getSensor(id);
    }

    @GetMapping("/getSensors")
    public List<Sensor> getSensors() {
        return sensorService.getSensors();
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

    @DeleteMapping("/deleteSensor/{id}")
    public String deleteSensor(@PathVariable int id) {
        sensorService.deleteSensor(id);
        return "Deleted Successfully!!";
    }

    @PostMapping("/insertSensors")
    public String insertSensor(@RequestBody List<SensorDTO> sensorDTO) {
        sensorService.insertSensors(sensorDTO);
        return "Sensors added successfully!!";
    }
}