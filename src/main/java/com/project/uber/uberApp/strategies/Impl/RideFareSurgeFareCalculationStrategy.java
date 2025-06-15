package com.project.uber.uberApp.strategies.Impl;

import com.project.uber.uberApp.enitities.RideRequest;
import com.project.uber.uberApp.services.DistanceService;
import com.project.uber.uberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareSurgeFareCalculationStrategy implements RideFareCalculationStrategy {
    private final DistanceService distanceService;
    private static final double SURGE_FACTOR = 2;

    @Override
    public double calculateFare(RideRequest rideRequest) {

        double distance = distanceService.calculateDistance(rideRequest.getPickUpLocation(),
                rideRequest.getDropOffLocation());

        return distance*RIDE_FARE_MULTIPLIER*SURGE_FACTOR;
    }
}
