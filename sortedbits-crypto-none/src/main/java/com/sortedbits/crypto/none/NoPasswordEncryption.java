package com.sortedbits.crypto.none;

import com.sortedbits.crypto.api.CryptoException;
import com.sortedbits.crypto.api.PasswordEncryption;

public class NoPasswordEncryption implements PasswordEncryption {

    @Override
    public String getName() {
        return "no-encryption";
    }

    @Override
    public String encrypt(String password, String plain) throws CryptoException {
        return plain;
    }

    @Override
    public String decrypt(String password, String encrypted) throws CryptoException {
        return encrypted;
    }
}
