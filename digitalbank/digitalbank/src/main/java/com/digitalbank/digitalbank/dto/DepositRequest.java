package com.digitalbank.digitalbank.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DepositRequest {
    private String bankName;
    private BigDecimal amount;
}
