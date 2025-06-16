package com.project.uber.uberApp.dto;

import lombok.Data;

import java.util.List;

@Data
public class WalletDto {

    private Long id;

    private UserDto user;

    private List<WalletTransactionDto> transactions;

    private Double balance;


}
