package com.sortedbits.crypto.cli;

import com.sortedbits.crypto.api.CryptoException;
import com.sortedbits.crypto.api.PasswordEncryption;

import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.lang.String.format;
import static java.lang.System.out;
import static java.util.ServiceLoader.load;
import static java.util.stream.StreamSupport.stream;

import java.util.List;

import static java.util.stream.IntStream.range;
import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        ServiceLoader<PasswordEncryption> loader = load(PasswordEncryption.class);
        List<ServiceLoader.Provider<PasswordEncryption>> providers = loader.stream().collect(toList());
        range(0, providers.size()).forEach(i -> out.println(format("%d - %s", i, providers.get(i).type().getName())));

        out.println("text:");
        String text = System.console().readLine();

        PasswordEncryption pbe = providers.get(0).get();
//        pbe.encrypt(null, "foo");

    }
}
