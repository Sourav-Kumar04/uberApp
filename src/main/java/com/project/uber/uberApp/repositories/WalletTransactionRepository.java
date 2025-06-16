package com.project.uber.uberApp.repositories;

import com.project.uber.uberApp.enitities.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction,Long> {
}
