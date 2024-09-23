package com.vehiclemgmt.Controller;

import com.vehiclemgmt.DTO.VehicleDTO;
import com.vehiclemgmt.Model.Vehicles;
import com.vehiclemgmt.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @GetMapping("/getVehicles")
    public List<Vehicles> getVehicles() {
        return vehicleService.getVehicle();
    }

    @PostMapping("/insertVehicle")
    public String insertVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.insertVehicle(vehicleDTO);
        return "Vehicle inserted successfully";
    }

    @PostMapping("/insertVehicles")
    public String insertVehicles(@RequestBody List<VehicleDTO> vehicleDTOs) {
        vehicleService.insertVehicles(vehicleDTOs);
        return "Vehicles inserted successfully";
    }
}