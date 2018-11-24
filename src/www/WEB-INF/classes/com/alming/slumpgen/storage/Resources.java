package com.alming.slumpgen.storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Resources {
    public static final String NAMES = "www/WEB-INF/res/names.json";
    public static final String NICKNAMES = "www/WEB-INF/res/nicknames.json";
    public static final String CREEDS = "www/WEB-INF/res/creeds.json";

    public static String getResource(String res) throws FileNotFoundException {
        return new BufferedReader(new FileReader(res))
            .lines()
            .collect(Collectors.joining())
            .toString();
    }
}