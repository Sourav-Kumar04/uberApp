package com.project.uber.uberApp.repositories;

import com.project.uber.uberApp.enitities.Driver;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//GEO spatial (postGIS) query
// ST_Distance(point1 ,point2)
// ST_Dwithin(point1, 10000)

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    //log(n)

    @Query(value = "SELECT d.*, ST_Distance(d.current_location, :pickUpLocation) AS distance " +
            " FROM driver d " +
            " WHERE d,available = true AND ST_Dwithin(d.current_location, :pickUpLocation, 10000) "+
            "ORDER BY distance " +
            "LIMIT 10 "
            , nativeQuery = true
    )
    List<Driver> findTenNearestDrivers(Point pickUpLocation);



    @Query(value = "SELECT d.* " +
            " FROM driver d " +
            " WHERE d.available = true AND ST_Dwithin(d.current_location, :pickUpLocation, 15000) "+
            "ORDER BY d.rating DESC " +
            "LIMIT 10 "
            ,nativeQuery = true
    )
    List<Driver> findTenNearbyHighestRatedDrivers(Point pickUpLocation);
}
