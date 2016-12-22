package com.epam.alex.trainbooking.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ${AlexandrSerebryakov} on ${09.10.2016}.
 */
public class PropertyManager {
    private Properties properties;
    public PropertyManager(String propertyFileName) throws IOException {
        properties = new Properties();
        InputStream in = PropertyManager.class.getClassLoader().getResourceAsStream(propertyFileName);
            properties.load(in);
        }
    public Properties getProperties() {
        return properties;
    }

}


