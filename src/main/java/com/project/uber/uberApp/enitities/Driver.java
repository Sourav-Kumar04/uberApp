package com.project.uber.uberApp.enitities;

import jakarta.persistence.*;
import lombok.*;
import org.geolatte.geom.Point;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(indexes = {
        @Index(name = "idx_driver_vehicle_id", columnList = "vehicleId")
})
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
