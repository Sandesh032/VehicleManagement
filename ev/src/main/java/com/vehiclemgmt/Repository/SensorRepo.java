package com.vehiclemgmt.Repository;

import com.vehiclemgmt.Model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepo extends JpaRepository<Sensor, Integer> {
}