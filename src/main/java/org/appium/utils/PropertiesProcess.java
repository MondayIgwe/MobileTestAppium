package org.appium.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesProcess {
    static Properties properties;
    public static String username;
    public static String password;
    static FileInputStream propFile;

    static {
        try {
            propFile = new FileInputStream("./src/main/resources/usercredentials.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getProperties() throws IOException {
        properties = new Properties();
        properties.load(propFile);
        username = properties.getProperty("user");
        password = properties.getProperty("passcode");
    }
}
