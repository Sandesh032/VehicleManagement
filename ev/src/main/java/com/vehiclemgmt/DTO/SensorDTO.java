package com.vehiclemgmt.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SensorDTO {
    private int sensor_id;
    private int vehicle_id;
    private String sensor_type;
    private double sensor_reading;
    private String timestamp;
}