package com.digitalbank.digitalbank.factory;

import com.digitalbank.digitalbank.services.PaymentChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentFactory {

    private final Map<String, PaymentChannelService> bankMap;

    public PaymentChannelService getDigitalBank(String bankName) {
        PaymentChannelService paymentChannelService = bankMap.get(bankName.toLowerCase().trim());
        if (bankName == null) {
            throw new IllegalArgumentException("Unknown Bank: " + bankName);
        }
        return paymentChannelService;
    }

}
