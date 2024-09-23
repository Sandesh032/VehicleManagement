package com.vehiclemgmt.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MaintenanceDTO {
    private int maintenance_id;
    private int vehicle_id;
    private String maintenance_type;
    private String maintenance_date;
    private double maintenance_cost;
}