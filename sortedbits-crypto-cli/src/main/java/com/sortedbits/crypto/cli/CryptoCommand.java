package com.sortedbits.crypto.cli;

import com.sortedbits.crypto.api.PasswordEncryption;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

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

public class CryptoCommand {

    public static void main(String[] args) throws IOException {

        ServiceLoader<PasswordEncryption> loader = load(PasswordEncryption.class);

        List<ServiceLoader.Provider<PasswordEncryption>> providers = loader.stream().collect(toList());
        range(0, providers.size()).forEach(i -> out.println(format("%d - %s", i, providers.get(i).type().getName())));


//        Terminal terminal = TerminalBuilder.builder().build();
//        LineReader reader = LineReaderBuilder
//                .builder()
//                .terminal(terminal)
//                .build();
//        reader.readLine(">");

        // System.console().readLine(">");

        //PasswordEncryption pbe = providers.get(0).get();
        //pbe.encrypt(null, "foo");

    }
}
