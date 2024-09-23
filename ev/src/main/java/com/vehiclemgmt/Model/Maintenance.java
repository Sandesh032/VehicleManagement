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
@Entity(name = "maintenance_table")
public class Maintenance {
    @Id
    private int maintenance_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id")
    private Vehicles vehicles;

    @Column
    private String maintenance_type;

    @Column
    private Date maintenance_date;

    @Column
    private double maintenance_cost;
}