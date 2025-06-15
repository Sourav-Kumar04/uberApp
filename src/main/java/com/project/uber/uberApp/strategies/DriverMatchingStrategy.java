package com.project.uber.uberApp.strategies;

import com.project.uber.uberApp.enitities.Driver;
import com.project.uber.uberApp.enitities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {

    List<Driver> findMatchingDrivers(RideRequest rideRequest);
}
