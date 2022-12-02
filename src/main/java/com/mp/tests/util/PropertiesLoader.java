package com.mp.tests.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class PropertiesLoader {

    public static Properties loadProperties() {

        Properties configuration = new Properties();
        InputStream inputStream = PropertiesLoader.class
                .getClassLoader()
                .getResourceAsStream("application.properties");
        try {
            configuration.load(inputStream);
            Objects.requireNonNull(inputStream).close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return configuration;
    }

}
