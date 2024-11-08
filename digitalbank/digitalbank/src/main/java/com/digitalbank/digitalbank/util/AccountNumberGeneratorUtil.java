package com.digitalbank.digitalbank.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountNumberGeneratorUtil {

    public static int generateAccountNumber() {
        SecureRandom secureRandom = new SecureRandom();

        return secureRandom.nextInt(99999999 - 10000000) + 10000000;
    }
}
