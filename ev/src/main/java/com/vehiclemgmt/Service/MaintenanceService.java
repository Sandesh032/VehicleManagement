package com.vehiclemgmt.Service;

import com.vehiclemgmt.DTO.MaintenanceDTO;
import com.vehiclemgmt.Model.Maintenance;
import com.vehiclemgmt.Model.Vehicles;
import com.vehiclemgmt.Repository.MaintenanceRepo;
import com.vehiclemgmt.Repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MaintenanceService {
    @Autowired
    MaintenanceRepo maintenanceRepo;

    @Autowired
    VehicleRepo vehicleRepo;

    public void insertMaintenance(MaintenanceDTO maintenanceDTO) {
        Vehicles vehicle = vehicleRepo.findById(maintenanceDTO.getVehicle_id())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenance_id(maintenanceDTO.getMaintenance_id());
        maintenance.setVehicles(vehicle);
        maintenance.setMaintenance_type(maintenanceDTO.getMaintenance_type());
        maintenance.setMaintenance_date(convertStringToDate(maintenanceDTO.getMaintenance_date()));
        maintenance.setMaintenance_cost(maintenanceDTO.getMaintenance_cost());

        maintenanceRepo.save(maintenance);
    }

    public void insertMaintenances(List<MaintenanceDTO> maintenanceDTOs) {
        for (MaintenanceDTO maintenanceDTO : maintenanceDTOs) {
            insertMaintenance(maintenanceDTO);
        }
    }

    public List<Maintenance> getMaintenance() {
        return maintenanceRepo.findAll();
    }

    private Date convertStringToDate(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            return sdf.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing date", e);
        }
    }

    public List<Maintenance> getHistory(int id) {
        return maintenanceRepo.findAllByVehiclesVehicleId(id);
    }
}