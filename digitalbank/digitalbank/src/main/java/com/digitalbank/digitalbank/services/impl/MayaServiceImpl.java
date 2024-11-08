package com.digitalbank.digitalbank.services.impl;

import com.digitalbank.digitalbank.dao.AccountRepository;
import com.digitalbank.digitalbank.dao.UserRepository;
import com.digitalbank.digitalbank.dto.AccountRequest;
import com.digitalbank.digitalbank.dto.DepositRequest;
import com.digitalbank.digitalbank.dto.WithdrawRequest;
import com.digitalbank.digitalbank.entity.AccountEntity;
import com.digitalbank.digitalbank.entity.UserEntity;
import com.digitalbank.digitalbank.enums.Status;
import com.digitalbank.digitalbank.exception.AccountNotFoundException;
import com.digitalbank.digitalbank.services.PaymentChannelService;
import com.digitalbank.digitalbank.util.AccountNumberGeneratorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("maya")
@RequiredArgsConstructor
public class MayaServiceImpl implements PaymentChannelService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Override
    public AccountEntity createAccount(AccountRequest accountRequest) {
        return accountRepository.save(AccountEntity.builder()
            .user(UserEntity.builder()
                .name(accountRequest.getFullName())
                .occupation(accountRequest.getOccupation())
                .build())
            .accountType(accountRequest.getBankName())
            .id(Long.valueOf(AccountNumberGeneratorUtil.generateAccountNumber()))
            .status(Status.ACTIVE.name())
            .balance(new BigDecimal(0))
            .build());
    }

    @Override
    public AccountEntity deposit(DepositRequest depositRequest, Long id) {
        AccountEntity accountEntity = getAccount(depositRequest.getBankName(), id);
        accountEntity.addToBalance(depositRequest.getAmount());

        return accountRepository.save(accountEntity);
    }

    @Override
    public AccountEntity getAccount(String accountType, Long id) {
        return accountRepository.findByAccountTypeAndId(accountType, id)
            .orElseThrow(() -> new AccountNotFoundException("Account not found!"));
    }

    @Override
    public AccountEntity withdraw(WithdrawRequest withdrawRequest, Long id) {
        AccountEntity accountEntity = getAccount(withdrawRequest.getBankName(), id);
        accountEntity.deductToBalance(withdrawRequest.getAmount());

        return accountRepository.save(accountEntity);
    }

}
