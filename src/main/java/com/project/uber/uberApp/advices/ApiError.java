package com.project.uber.uberApp.advices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    private HttpStatus status;
    private String message;
    private List<String> subErrors;

}
