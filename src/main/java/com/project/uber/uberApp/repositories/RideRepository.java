package com.project.uber.uberApp.repositories;

import com.project.uber.uberApp.enitities.Driver;
import com.project.uber.uberApp.enitities.Ride;
import com.project.uber.uberApp.enitities.Rider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
    Page<Ride> findByRider(Rider rider, Pageable pageRequest);

    Page<Ride> findByDriver(Driver driver, Pageable pageRequest);
}
