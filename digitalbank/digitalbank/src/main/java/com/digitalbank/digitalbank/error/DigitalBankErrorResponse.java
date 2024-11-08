package com.digitalbank.digitalbank.error;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DigitalBankErrorResponse {
    private String errorMessage;
    private String errorCode;
}
