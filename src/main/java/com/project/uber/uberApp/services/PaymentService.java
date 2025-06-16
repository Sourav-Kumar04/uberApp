package com.project.uber.uberApp.services;

import com.project.uber.uberApp.enitities.Payment;
import com.project.uber.uberApp.enitities.Ride;
import com.project.uber.uberApp.enitities.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus paymentStatus);


}
