package com.example.mcbcommon.util;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * @author chunbo.ma.o
 * @since 2023/12/15
 */
public class ValidationUtils {

    static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public static Validator getValidator() {
        return validator;
    }

}
