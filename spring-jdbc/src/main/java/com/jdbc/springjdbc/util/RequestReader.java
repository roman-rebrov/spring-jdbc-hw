package com.jdbc.springjdbc.util;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.stream.Collectors;

public class RequestReader {

    public static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
