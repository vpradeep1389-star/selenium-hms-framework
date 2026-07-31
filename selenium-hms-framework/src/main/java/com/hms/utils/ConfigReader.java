package com.hms.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Loads src/test/resources/config.properties once and exposes typed getters.
 */
public class ConfigReader {

    private static Properties properties;

    private static final String CONFIG_PATH = "src/test/resources/config.properties";

    private static void load() {
        if (properties == null) {
            properties = new Properties();
            try (FileInputStream fis = new FileInputStream(CONFIG_PATH)) {
                properties.load(fis);
            } catch (IOException e) {
                throw new RuntimeException("Unable to load config.properties at " + CONFIG_PATH, e);
            }
        }
    }

    public static String get(String key) {
        load();
        return properties.getProperty(key);
    }

    public static String getBaseUrl() {
        return get("base.url");
    }

    public static String getBrowser() {
        return get("browser");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(get("headless"));
    }

    public static int getImplicitWait() {
        return Integer.parseInt(get("implicit.wait"));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(get("explicit.wait"));
    }

    public static String getUsername() {
        return get("hms.username");
    }

    public static String getPassword() {
        return get("hms.password");
    }
}
