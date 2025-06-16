package com.project.uber.uberApp.repositories;

import com.project.uber.uberApp.enitities.Payment;
import com.project.uber.uberApp.enitities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    Optional<Payment> findByRide(Ride ride);
}
