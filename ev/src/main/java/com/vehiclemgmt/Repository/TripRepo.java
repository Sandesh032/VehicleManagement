package com.vehiclemgmt.Repository;

import com.vehiclemgmt.Model.Trips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepo extends JpaRepository<Trips, Integer> {
}