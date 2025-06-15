package com.project.uber.uberApp.enitities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "wallet" , fetch = FetchType.LAZY)
    private List<WalletTransactions> transactions;

    private Double balance;


}
