package com.project.uber.uberApp.dto;

import com.project.uber.uberApp.enitities.enums.PaymentMethod;
import com.project.uber.uberApp.enitities.enums.RideStatus;
import lombok.Data;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
public class RideDto {

    private Long id;

    private PointDto pickUpLocation;

    private PointDto dropOffLocation;

    private LocalDateTime createdTime;

    private RiderDto rider;

    private DriverDto driver;

    private PaymentMethod paymentMethod;

    private RideStatus rideRequestStatus;

    private Double fare;

    private String otp;

    private LocalDateTime startedAt;

    private LocalDateTime endedAt;
}
