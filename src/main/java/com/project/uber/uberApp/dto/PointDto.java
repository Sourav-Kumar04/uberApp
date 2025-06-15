package com.project.uber.uberApp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor//required by jackson
public class PointDto {

    private double[] coordinates;
    private String type = "point";

    public PointDto(double[] coordinates) {
        this.coordinates = coordinates;
    }
}
