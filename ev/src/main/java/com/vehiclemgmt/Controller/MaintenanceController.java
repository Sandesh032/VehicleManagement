package com.vehiclemgmt.Controller;

import com.vehiclemgmt.DTO.MaintenanceDTO;
import com.vehiclemgmt.Model.Maintenance;
import com.vehiclemgmt.Service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MaintenanceController {
    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/getMaintenance")
    public List<Maintenance> getMaintenance() {
        return maintenanceService.getMaintenance();
    }

    @PostMapping("/insertMaintenance")
    public String insertMaintenance(@RequestBody MaintenanceDTO maintenanceDTO) {
        maintenanceService.insertMaintenance(maintenanceDTO);
        return "Maintenance inserted successfully";
    }

    @GetMapping("/{id}/maintenance_history")
    public List<Maintenance> getHistory(@PathVariable int id) {
        return maintenanceService.getHistory(id);
    }

    @PostMapping("/insertMaintenances")
    public String insertMaintenances(@RequestBody List<MaintenanceDTO> maintenanceDTOs) {
        maintenanceService.insertMaintenances(maintenanceDTOs);
        return "Maintenance records inserted successfully";
    }
}