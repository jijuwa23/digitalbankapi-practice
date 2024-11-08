package com.digitalbank.digitalbank.controller;

import com.digitalbank.digitalbank.dto.AccountRequest;
import com.digitalbank.digitalbank.dto.DepositRequest;
import com.digitalbank.digitalbank.dto.GetAccountRequest;
import com.digitalbank.digitalbank.dto.WithdrawRequest;
import com.digitalbank.digitalbank.entity.AccountEntity;
import com.digitalbank.digitalbank.factory.PaymentFactory;
import com.digitalbank.digitalbank.services.PaymentChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/digital")
public class DigitalBankController {
    private final PaymentFactory paymentFactory;

    @PostMapping("/accounts")
    public ResponseEntity<AccountEntity> createAccount(@RequestBody AccountRequest accountRequest) {
        PaymentChannelService paymentChannelService = paymentFactory.getDigitalBank(accountRequest.getBankName());
        return ResponseEntity.ok(paymentChannelService.createAccount(accountRequest));
    }


    @PutMapping("/accounts/deposit/{id}")
    public ResponseEntity<AccountEntity> deposit(@RequestBody DepositRequest depositRequest,
                                                 @PathVariable("id") Long id) {
        PaymentChannelService paymentChannelService = paymentFactory.getDigitalBank(depositRequest.getBankName());
        return ResponseEntity.ok(paymentChannelService.deposit(depositRequest, id));
    }


    @PutMapping("/accounts/withdraw/{id}")
    public ResponseEntity<AccountEntity> withdraw(@RequestBody WithdrawRequest withdrawRequest,
                                                  @PathVariable("id") Long id) {
        PaymentChannelService paymentChannelService = paymentFactory.getDigitalBank(withdrawRequest.getBankName());
        return ResponseEntity.ok(paymentChannelService.withdraw(withdrawRequest, id));
    }


    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountEntity> getAccountById(@RequestBody GetAccountRequest getAccountRequest, @PathVariable("id") Long id) {
        PaymentChannelService paymentChannelService = paymentFactory.getDigitalBank(getAccountRequest.getBankName());
        return ResponseEntity.ok(paymentChannelService.getAccount(getAccountRequest.getBankName(), id));
    }

}
