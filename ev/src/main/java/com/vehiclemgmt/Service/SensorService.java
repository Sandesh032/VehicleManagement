package com.vehiclemgmt.Service;

import com.vehiclemgmt.DTO.SensorDTO;
import com.vehiclemgmt.Model.Sensor;
import com.vehiclemgmt.Model.Vehicles;
import com.vehiclemgmt.Repository.SensorRepo;
import com.vehiclemgmt.Repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SensorService {
    @Autowired
    SensorRepo sensorRepo;

    @Autowired
    VehicleRepo vehicleRepo;

    @Cacheable(value = "sensors", key = "#id")
    public Sensor getSensor(int id) {
        return sensorRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Sensor id mismatched!")
        );
    }

    public List<Sensor> getSensors() {
        return sensorRepo.findAll();
    }

    public void insertSensor(SensorDTO sensorDTO) {
        Sensor sensor = new Sensor();

        Vehicles vehicle = vehicleRepo.findById(sensorDTO.getVehicle_id()).
                orElseThrow(() -> new RuntimeException("Vehicle not found"));

        sensor.setSensor_id(sensorDTO.getSensor_id());
        sensor.setVehicle(vehicle);
        sensor.setSensor_reading(sensorDTO.getSensor_reading());
        sensor.setSensor_type(sensorDTO.getSensor_type());
        sensor.setTimestamp(sensorDTO.getTimestamp());

        sensorRepo.save(sensor);
    }

    public void insertSensors(List<SensorDTO> sensorDTO) {
        for (SensorDTO sensor : sensorDTO) {
            insertSensor(sensor);
        }
    }

    public void updateSensor(SensorDTO sensorDTO) {
        Sensor sensor = sensorRepo.findById(sensorDTO.getSensor_id())
                .orElseThrow(() -> new RuntimeException("Sensor not found!!"));
        Vehicles vehicle = vehicleRepo.findById(sensorDTO.getVehicle_id())
                .orElseThrow(() -> new RuntimeException("Vehicle not found!!"));

        sensor.setSensor_id(sensorDTO.getSensor_id());
        sensor.setSensor_type(sensorDTO.getSensor_type());
        sensor.setVehicle(vehicle);
        sensor.setSensor_reading(sensorDTO.getSensor_reading());
        sensor.setTimestamp(sensorDTO.getTimestamp());

        sensorRepo.save(sensor);
    }

    public void deleteSensor(int id) {
        Sensor sensor = sensorRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Id not found!!"));
        sensorRepo.delete(sensor);
    }

    public List<Vehicles> detectAnomalies() {
        List<Vehicles> vehiclesWithAnomalies = new ArrayList<Vehicles>();
        List<Sensor> allSensors = sensorRepo.findAll();
        for (Sensor sensor : allSensors) {
            if (sensor.getSensor_type().equals("Speed") && sensor.getSensor_reading() > 120 ||
                    sensor.getSensor_type().equals("Fuel") && sensor.getSensor_reading() < 10) {
                vehiclesWithAnomalies.add(sensor.getVehicle());
            }
        }
        return vehiclesWithAnomalies;
    }
}