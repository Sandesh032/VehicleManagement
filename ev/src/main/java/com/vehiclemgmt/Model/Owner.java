package com.vehiclemgmt.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "owners_table")
@Component
public class Owner implements Serializable {
    @Id
    private int owner_id;
    @Column
    private String name;
    @Column
    private String email;
}