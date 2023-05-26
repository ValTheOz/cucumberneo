package com.neotech.cucumber.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigsReader {  private static Properties properties;
    private static final String propertyFilePath = "src/main/resources/configs.properties";
    private ConfigsReader(){}

    static {
        try {
            FileInputStream inputStream = new FileInputStream(propertyFilePath);
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperties(String keyName){
        return properties.getProperty(keyName);
    }
    public static void setProperty(String key, String value){
        //save the data into file
        properties.setProperty(key, value);
    }
}


