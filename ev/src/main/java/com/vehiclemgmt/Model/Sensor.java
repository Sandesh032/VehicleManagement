package com.vehiclemgmt.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Entity(name = "sensors_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sensor implements Serializable {
    @Id
    private int sensor_id;
    @OneToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id")
    private Vehicles vehicle;
    @Column
    private String sensor_type;
    @Column
    private double sensor_reading;
    @Column
    private String timestamp;
}