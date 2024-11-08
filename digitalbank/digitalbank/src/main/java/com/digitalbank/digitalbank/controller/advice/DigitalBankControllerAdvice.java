package com.digitalbank.digitalbank.controller.advice;

import com.digitalbank.digitalbank.controller.DigitalBankController;
import com.digitalbank.digitalbank.error.DigitalBankErrorResponse;
import com.digitalbank.digitalbank.exception.AccountNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = {DigitalBankController.class})
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
public class DigitalBankControllerAdvice {

    @ExceptionHandler({AccountNotFoundException.class})
    public final ResponseEntity<DigitalBankErrorResponse> handleAccountNotFoundException(AccountNotFoundException ex) {
        return new ResponseEntity<>(DigitalBankErrorResponse.builder()
            .errorMessage("Account Not Found!")
            .errorCode("400")
            .build(), HttpStatus.BAD_REQUEST);
    }
}
