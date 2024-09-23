package com.vehiclemgmt.Service;

import com.vehiclemgmt.DTO.TripDTO;
import com.vehiclemgmt.Model.Trips;
import com.vehiclemgmt.Model.Vehicles;
import com.vehiclemgmt.Repository.TripRepo;
import com.vehiclemgmt.Repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TripService {
    @Autowired
    TripRepo tripRepo;

    @Autowired
    VehicleRepo vehicleRepo;

    public void insertTrip(TripDTO tripDTO) {
        Vehicles vehicle = vehicleRepo.findById(tripDTO.getVehicle_id())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        Trips trip = new Trips();
        trip.setTrip_id(tripDTO.getTrip_id());
        trip.setVehicles(vehicle);
        trip.setStart_time(convertStringToDate(tripDTO.getStart_time()));
        trip.setEnd_time(convertStringToDate(tripDTO.getEnd_time()));
        trip.setStart_location(tripDTO.getStart_location());
        trip.setEnd_location(tripDTO.getEnd_location());
        trip.setDistance_travelled(tripDTO.getDistance_travelled());

        tripRepo.save(trip);
    }

    public void insertTrips(List<TripDTO> tripDTOs) {
        for (TripDTO tripDTO : tripDTOs) {
            insertTrip(tripDTO);
        }
    }

    public List<Trips> getTrips() {
        return tripRepo.findAll();
    }

    public List<Vehicles> frequentTrips() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        Date last7days = calendar.getTime();

        List<Vehicles> vehiclesWithFrequentTrips = new ArrayList<Vehicles>();

        List<Trips> allTrips = tripRepo.findAll();
        HashMap<Vehicles, Integer> hash = new HashMap<>();

        for (Trips trip : allTrips) {
            if (trip.getStart_time().after(last7days)) {
                Vehicles vehicle = trip.getVehicles();
                hash.put(vehicle, hash.getOrDefault(vehicle, 0) + 1);
            }
        }

        for (Vehicles vehicle : hash.keySet()) {
            if (hash.get(vehicle) > 5) {
                vehiclesWithFrequentTrips.add(vehicle);
            }
        }
        return vehiclesWithFrequentTrips;
    }

    private Date convertStringToDate(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            return sdf.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing date", e);
        }
    }
}