package com.project.uber.uberApp.services.impl;

import com.project.uber.uberApp.dto.DriverDto;
import com.project.uber.uberApp.dto.SignUpDto;
import com.project.uber.uberApp.dto.UserDto;
import com.project.uber.uberApp.enitities.User;
import com.project.uber.uberApp.enitities.enums.Role;
import com.project.uber.uberApp.exceptions.RuntimeConflictExceptions;
import com.project.uber.uberApp.repositories.UserRepository;
import com.project.uber.uberApp.services.AuthService;
import com.project.uber.uberApp.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RiderService riderService;

    //requires spring security
    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    @Transactional//either this whole function will execute or roll back ... so if Rider is not create then whole thing will we rolled back
    public UserDto signup(SignUpDto signUpDto) {
        User user = userRepository.findByEmail(signUpDto.getEmail()).orElse(null);

        if(user != null){
           throw new RuntimeConflictExceptions("Cannot signUp, User already exists with email " + signUpDto.getEmail());
        }

            User mappedUser = modelMapper.map(signUpDto, User.class);
            mappedUser.setRoles(Set.of(Role.RIDER));//BY default any user will be registered as rider

            User savedUser = userRepository.save(mappedUser);

            //create user related entities
        riderService.createNewRider(savedUser);

        //TODO add wallet related service here


        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public DriverDto onBoardNewDriver(Long userId) {
        return null;
    }
}
