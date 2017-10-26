package com.sortedbits.crypto.cli;

import com.sortedbits.crypto.api.PasswordEncryption;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ServiceLoader;

import static java.lang.String.format;
import static java.lang.System.out;
import static java.util.ServiceLoader.load;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class CryptoTool {

    public static void main(String[] args) throws IOException {

        ServiceLoader<PasswordEncryption> loader = load(PasswordEncryption.class);

        List<ServiceLoader.Provider<PasswordEncryption>> providers = loader.stream().collect(toList());

        System.setProperty("org.beryx.textio.TextTerminal" , "org.beryx.textio.swing.SwingTextTerminal");

        TextIO textIO = TextIoFactory.getTextIO();
        TextTerminal term = textIO.getTextTerminal();

        range(0, providers.size()).forEach(i -> term.println(format("%d - %s", i + 1, providers.get(i).type().getName())));

        int n = textIO.newIntInputReader()
                .withMinVal(1)
                .withMaxVal(providers.size())
                .read("Provider") - 1;

        term.println();

        String password = textIO.newStringInputReader()
                .withMinLength(6)
                .withInputMasking(true)
                .read("Password");

        term.println();

        String plain = textIO
                .newStringInputReader()
                .read("Plain text");

        term.println();

        PasswordEncryption pbe = providers.get(n).get();
        String encrypted = pbe.encrypt(password, plain);

        term.println(format("Encrypted text: %s", encrypted));
    }
}
