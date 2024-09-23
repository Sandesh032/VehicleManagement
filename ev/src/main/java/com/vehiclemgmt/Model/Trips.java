package com.vehiclemgmt.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity(name = "trips_table")
public class Trips {
    @Id
    private int trip_id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id")
    private Vehicles vehicles;
    @Column
    private Date start_time;
    @Column
    private Date end_time;
    @Column
    private String start_location;
    @Column
    private String end_location;
    @Column
    private double distance_travelled;
}