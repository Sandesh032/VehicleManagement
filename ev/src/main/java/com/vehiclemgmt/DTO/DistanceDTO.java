package com.vehiclemgmt.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DistanceDTO {
    private String make;
    private String model;
    private String ownerName;
    private double distance;
}