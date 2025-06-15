package com.project.uber.uberApp.strategies;

import com.project.uber.uberApp.enitities.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FARE_MULTIPLIER = 10;

    double calculateFare(RideRequest rideRequest);

}
