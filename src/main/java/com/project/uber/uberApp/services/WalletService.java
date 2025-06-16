package com.project.uber.uberApp.services;

import com.project.uber.uberApp.enitities.Ride;
import com.project.uber.uberApp.enitities.User;
import com.project.uber.uberApp.enitities.Wallet;
import com.project.uber.uberApp.enitities.enums.TransactionMethod;

public interface WalletService {

    Wallet addMoneyToWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod);

    Wallet deductMoneyFromWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod);

    void withdrawMoneyFromWallet();

    Wallet findWalletById(Long walletId);

    Wallet createNewWallet(User user);

    Wallet findByUser(User user);

}
