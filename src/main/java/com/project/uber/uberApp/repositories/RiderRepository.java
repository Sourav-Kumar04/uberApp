package com.project.uber.uberApp.repositories;

import com.project.uber.uberApp.enitities.Rider;
import com.project.uber.uberApp.enitities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {

    Optional<Rider> findByUser(User user);
}
