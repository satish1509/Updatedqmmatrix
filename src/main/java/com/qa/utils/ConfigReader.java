package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;
    private final String configFilePath = "./src/test/resources/Config/config.properties";

    /**
     * This method is used to load the properties from config.properties file
     * @return it returns Properties prop object
     */
    public Properties readConfig() {
        prop = new Properties();
        try (FileInputStream fis = new FileInputStream(configFilePath)) {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Browser from config: " + prop.getProperty("browser"));
        return prop;
    }

    /**
     * This method is used to write a key-value pair to config.properties file
     * @param key the key to store
     * @param value the value to store
     */
    public void writeConfig(String key, String value) {
        try {
            // Load existing properties first
            if (prop == null) {
                prop = new Properties();
            }
            try (FileInputStream fis = new FileInputStream(configFilePath)) {
                prop.load(fis);
            } catch (IOException e) {
                // If file doesn't exist or error loading, we continue with empty props
            }

            // Set or update the property
            prop.setProperty(key, value);

            // Save properties back to file
            try (FileOutputStream fos = new FileOutputStream(configFilePath)) {
                prop.store(fos, "Updated property " + key);
            }

            System.out.println("Saved " + key + " = " + value + " to config.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
