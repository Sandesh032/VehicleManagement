package com.vehiclemgmt.Service;

import com.vehiclemgmt.DTO.VehicleDTO;
import com.vehiclemgmt.Model.Owner;
import com.vehiclemgmt.Model.Vehicles;
import com.vehiclemgmt.Repository.OwnerRepo;
import com.vehiclemgmt.Repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    VehicleRepo vehicleRepo;

    @Autowired
    OwnerRepo ownerRepo;

    public void insertVehicle(VehicleDTO vehicleDTO) {
        Optional<Owner> optOwner = ownerRepo.findById(vehicleDTO.getOwner_id());
        Owner owner;
        if (optOwner.isPresent()) {
            owner = optOwner.get();
        } else {
            throw new RuntimeException("Owner Not Found!!");
        }
//        Owner owner = ownerRepo.findById(vehicleDTO.getOwner_id())
//                .orElseThrow(() -> new RuntimeException("Owner not found"));

        Vehicles vehicle = new Vehicles();
        vehicle.setVehicleId(vehicleDTO.getVehicle_id());
        vehicle.setMake(vehicleDTO.getMake());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setYear(vehicleDTO.getYear());
        vehicle.setFuel_type(vehicleDTO.getFuel_type());
        vehicle.setOwner(owner);

        vehicleRepo.save(vehicle);
    }

    public void insertVehicles(List<VehicleDTO> vehicleDTOs) {
        for (VehicleDTO vehicleDTO : vehicleDTOs) {
            insertVehicle(vehicleDTO);
        }
    }

    public List<Vehicles> getVehicle() {
        return vehicleRepo.findAll();
    }
}