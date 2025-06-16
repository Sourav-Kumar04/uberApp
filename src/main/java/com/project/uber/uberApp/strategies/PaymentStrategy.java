package com.project.uber.uberApp.strategies;

import com.project.uber.uberApp.enitities.Payment;

public interface PaymentStrategy {

    Double PLATFORM_COMMISSION = 0.3;

    void processPayment(Payment payment);
}
