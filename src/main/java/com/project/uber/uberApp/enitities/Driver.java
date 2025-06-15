package com.project.uber.uberApp.enitities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.geolatte.geom.Point;

@Entity
@Getter
@Setter
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double rating;

    private boolean available;

    private String vehicleId;

    @Column(columnDefinition = "Geometry(Point, 4326)") //way to create Geometry type data in postGres DB
    private Point currentLocation;


}
