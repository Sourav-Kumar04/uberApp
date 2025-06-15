package com.project.uber.uberApp.configs;

import com.project.uber.uberApp.dto.DriverDto;
import com.project.uber.uberApp.dto.PointDto;
import com.project.uber.uberApp.dto.RiderDto;
import com.project.uber.uberApp.dto.UserDto;
import com.project.uber.uberApp.enitities.Driver;
import com.project.uber.uberApp.enitities.Rider;
import com.project.uber.uberApp.enitities.User;
import com.project.uber.uberApp.utils.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();

        mapper.typeMap(PointDto.class , Point.class).setConverter(context -> {
            PointDto pointDto = context.getSource();
            return GeometryUtil.createPoint(pointDto);
        });

        mapper.typeMap(Point.class, PointDto.class).setConverter(context -> {
            Point point = context.getSource();
            double coordinates[] = {
                    point.getX(),
                    point.getY()
            };
            return new PointDto(coordinates);
        });

        // Rider -> RiderDto (map nested user)
        mapper.typeMap(Rider.class, RiderDto.class).addMappings(m ->
                m.map(Rider::getUser, RiderDto::setUserDto)
        );

        // Driver -> DriverDto (map nested user)
        mapper.typeMap(Driver.class, DriverDto.class).addMappings(m ->
                m.map(Driver::getUser, DriverDto::setUserDto)
        );

        // User -> UserDto (optional, but useful)
        mapper.typeMap(User.class, UserDto.class);


        return mapper;
    }
}
