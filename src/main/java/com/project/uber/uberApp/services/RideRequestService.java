package com.project.uber.uberApp.services;

import com.project.uber.uberApp.enitities.RideRequest;

public interface RideRequestService {

    RideRequest findRideRequestById(Long rideRequestId);


    void update(RideRequest rideRequest);
}
