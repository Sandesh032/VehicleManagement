package com.vehiclemgmt.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripDTO {
    private int trip_id;
    private int vehicle_id;
    private String start_time;
    private String end_time;
    private String start_location;
    private String end_location;
    private double distance_travelled;
}