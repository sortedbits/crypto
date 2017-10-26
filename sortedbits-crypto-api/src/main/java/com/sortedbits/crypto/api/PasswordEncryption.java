package com.sortedbits.crypto.api;

public interface PasswordEncryption {

    String getName();

    String encrypt(String password, String plain) throws CryptoException;

    String decrypt(String password, String encrypted) throws CryptoException;

}
