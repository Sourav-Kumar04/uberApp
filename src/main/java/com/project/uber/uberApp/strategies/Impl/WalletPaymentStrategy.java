package com.project.uber.uberApp.strategies.Impl;

import com.project.uber.uberApp.enitities.Driver;
import com.project.uber.uberApp.enitities.Payment;
import com.project.uber.uberApp.enitities.Rider;
import com.project.uber.uberApp.enitities.enums.PaymentStatus;
import com.project.uber.uberApp.enitities.enums.TransactionMethod;
import com.project.uber.uberApp.repositories.PaymentRepository;
import com.project.uber.uberApp.services.WalletService;
import com.project.uber.uberApp.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Rider has 232 & Driver has 500 in their wallet
//Ride costs 100
//Commission -> 30
//Rider -> 232-100 = 132
//Driver -> 500 + (100-30) = 570



@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

        walletService.deductMoneyFromWallet(rider.getUser()
                ,payment.getAmount()
                ,null
                ,payment.getRide()
                , TransactionMethod.RIDE);

        double driversCut = payment.getAmount()*(1-PLATFORM_COMMISSION);

        walletService.addMoneyToWallet(driver.getUser()
                , driversCut
                ,null
                ,payment.getRide()
                ,TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
