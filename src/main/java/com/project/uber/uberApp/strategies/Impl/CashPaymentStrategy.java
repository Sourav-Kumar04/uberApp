package com.project.uber.uberApp.strategies.Impl;

import com.project.uber.uberApp.enitities.Driver;
import com.project.uber.uberApp.enitities.Payment;
import com.project.uber.uberApp.enitities.enums.PaymentStatus;
import com.project.uber.uberApp.enitities.enums.TransactionMethod;
import com.project.uber.uberApp.repositories.PaymentRepository;
import com.project.uber.uberApp.services.WalletService;
import com.project.uber.uberApp.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// Rider -> 100
//Driver -> 70 and deduct 30 rupees from Drivers waller


@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();

//        Wallet driverWallet = walletService.findByUser(driver.getUser());

        double platformCommission = (payment.getAmount())*PLATFORM_COMMISSION;

        walletService.deductMoneyFromWallet(driver.getUser()
                ,platformCommission
                , null
                , payment.getRide()
                , TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);

    }
}
