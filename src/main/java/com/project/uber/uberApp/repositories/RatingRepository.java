package com.project.uber.uberApp.repositories;

import com.project.uber.uberApp.enitities.Driver;
import com.project.uber.uberApp.enitities.Rating;
import com.project.uber.uberApp.enitities.Ride;
import com.project.uber.uberApp.enitities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByDriver(Driver driver);

    List<Rating> findByRider(Rider rider);

    Optional<Rating> findByRide(Ride ride);
}
