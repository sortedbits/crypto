package com.sortedbits.crypto.jasypt;

import com.sortedbits.crypto.api.CryptoException;
import com.sortedbits.crypto.api.PasswordEncryption;
import org.jasypt.util.text.StrongTextEncryptor;

public class JasyptPasswordEncryption implements PasswordEncryption {

    @Override
    public String getName() {
        return "jasypt-encryption";
    }

    @Override
    public String encrypt(String password, String plain) throws CryptoException {
        StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
        textEncryptor.setPassword(password);
        return textEncryptor.encrypt(plain);
    }

    @Override
    public String decrypt(String password, String encrypted) throws CryptoException {
        StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
        textEncryptor.setPassword(password);
        return textEncryptor.decrypt(encrypted);
    }
}
