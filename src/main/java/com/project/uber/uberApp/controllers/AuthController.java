package com.project.uber.uberApp.controllers;

import com.project.uber.uberApp.dto.SignUpDto;
import com.project.uber.uberApp.dto.UserDto;
import com.project.uber.uberApp.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signUp")
    UserDto signUp(@RequestBody SignUpDto signUpDto){
        return authService.signup(signUpDto);
    }
}
