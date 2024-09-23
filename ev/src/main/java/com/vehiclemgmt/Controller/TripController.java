package com.vehiclemgmt.Controller;

import com.vehiclemgmt.DTO.TripDTO;
import com.vehiclemgmt.Model.Trips;
import com.vehiclemgmt.Model.Vehicles;
import com.vehiclemgmt.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TripController {
    @Autowired
    TripService tripService;

    @GetMapping("/getTrips")
    public List<Trips> getTrips() {
        return tripService.getTrips();
    }

    @GetMapping("/frequent_trips")
    public List<Vehicles> frequentTrips() {
        return tripService.frequentTrips();
    }

    @PostMapping("/insertTrip")
    public String insertTrip(@RequestBody TripDTO tripDTO) {
        tripService.insertTrip(tripDTO);
        return "Trip inserted successfully";
    }

    @PostMapping("/insertTrips")
    public String insertTrips(@RequestBody List<TripDTO> tripDTOs) {
        tripService.insertTrips(tripDTOs);
        return "Trips inserted successfully";
    }
}