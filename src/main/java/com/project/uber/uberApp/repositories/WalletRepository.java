package com.project.uber.uberApp.repositories;

import com.project.uber.uberApp.enitities.User;
import com.project.uber.uberApp.enitities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {
    Optional<Wallet> findByUser(User user);
}
