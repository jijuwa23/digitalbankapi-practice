package com.digitalbank.digitalbank.services;

import com.digitalbank.digitalbank.dto.AccountRequest;
import com.digitalbank.digitalbank.dto.DepositRequest;
import com.digitalbank.digitalbank.dto.WithdrawRequest;
import com.digitalbank.digitalbank.entity.AccountEntity;

public interface PaymentChannelService {
    AccountEntity createAccount(AccountRequest accountRequest);

    AccountEntity deposit(DepositRequest depositRequest, Long id);

    AccountEntity getAccount(String accountType, Long id);

    AccountEntity withdraw(WithdrawRequest withdrawRequest, Long id);

}
