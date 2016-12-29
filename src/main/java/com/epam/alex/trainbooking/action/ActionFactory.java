package com.epam.alex.trainbooking.action;

import com.epam.alex.trainbooking.util.PropertyManager;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by ${AlexandrSerebryakov} on ${09.10.2016}.
 */
public class ActionFactory {
    private static final String ACTION_PROPERTY_NAME = "action.properties";
    private Properties actionProperties;

    public void loadActions() throws IOException {

        PropertyManager propertyManager = null;
        propertyManager = new PropertyManager(ACTION_PROPERTY_NAME);
        actionProperties = propertyManager.getProperties();

    }

    public Action getAction(String actionName) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException {
        Action action;
        String actionClassName = actionProperties.getProperty(actionName);
        Class actionClass = Class.forName(actionClassName);
        action = (Action) actionClass.newInstance();

        return action;
    }
}


