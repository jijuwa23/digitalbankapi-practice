package com.digitalbank.digitalbank.dto;

import lombok.Data;

@Data
public class AccountRequest {
    private String fullName;
    private String occupation;
    private String bankName;
}
