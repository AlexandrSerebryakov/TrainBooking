package com.epam.alex.trainbooking.validator;

import com.epam.alex.trainbooking.validator.ParentValidator;
import com.epam.alex.trainbooking.validator.Validator;

/**
 * Validator on null for parameters in request
 */

public class NotNullValidator extends ParentValidator implements Validator {

    @Override
    public Boolean isValid(String parameter) {

        boolean checkResult = true;
        if (parameter == null) checkResult = false;
        return checkResult;
    }
}
