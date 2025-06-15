package com.project.uber.uberApp.strategies;

import com.project.uber.uberApp.strategies.Impl.DriverMatchingHighestRatedDriverStrategy;
import com.project.uber.uberApp.strategies.Impl.DriverMatchingNearestDriverStrategy;
import com.project.uber.uberApp.strategies.Impl.RideFareDefaultFareCalculationStrategy;
import com.project.uber.uberApp.strategies.Impl.RideFareSurgeFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {

    private final DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy;
    private final DriverMatchingNearestDriverStrategy nearestDriverStrategy;
    private final RideFareDefaultFareCalculationStrategy rideFareDefaultFareCalculationStrategy;
    private final RideFareSurgeFareCalculationStrategy rideFareSurgeFareCalculationStrategy;


    public DriverMatchingStrategy driverMatchingStrategy(double riderRating){
        //if rider rating is good then he/she will get driver with good rating
        if(riderRating > 4.75) {
            return highestRatedDriverStrategy;
        }
        else {
            return nearestDriverStrategy;
        }
    }

    public RideFareCalculationStrategy rideFareCalculationStrategy(){
        //6pm to 9pm select surgePricing
        LocalTime surgeStartTime = LocalTime.of(18,0);
        LocalTime surgeEndTime = LocalTime.of(21,0);
        LocalTime currentTime = LocalTime.now();

        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);

        if(isSurgeTime){
            return rideFareSurgeFareCalculationStrategy;
        }
        else {
            return rideFareDefaultFareCalculationStrategy;
        }
    }
}
