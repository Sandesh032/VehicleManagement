package com.vehiclemgmt.Repository;

import com.vehiclemgmt.Model.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicles, Integer> {
}