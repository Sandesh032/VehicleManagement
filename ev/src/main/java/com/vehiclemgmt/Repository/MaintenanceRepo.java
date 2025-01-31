package com.vehiclemgmt.Repository;

import com.vehiclemgmt.Model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRepo extends JpaRepository<Maintenance, Integer> {
    List<Maintenance> findAllByVehiclesVehicleId(int vehicleId);
}