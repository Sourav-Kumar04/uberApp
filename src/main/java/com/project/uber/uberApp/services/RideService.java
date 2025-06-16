package com.project.uber.uberApp.services;

import com.project.uber.uberApp.enitities.Driver;
import com.project.uber.uberApp.enitities.Ride;
import com.project.uber.uberApp.enitities.RideRequest;
import com.project.uber.uberApp.enitities.Rider;
import com.project.uber.uberApp.enitities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {

    Ride getRideById(Long rideId);

    Ride createNewRide(RideRequest rideRequest, Driver driver);

    Ride updateRideStatus(Ride ride, RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest);

}
