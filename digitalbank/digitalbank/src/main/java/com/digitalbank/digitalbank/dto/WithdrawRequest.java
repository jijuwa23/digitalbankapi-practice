package com.digitalbank.digitalbank.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WithdrawRequest {
    private String bankName;
    private BigDecimal amount;
}
