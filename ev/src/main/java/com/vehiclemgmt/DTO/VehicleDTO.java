package com.vehiclemgmt.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    private int vehicle_id;
    private String make;
    private String model;
    private int year;
    private String fuel_type;
    private int owner_id;
}