package ru.kpfu.itis.utils.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kamil Karimov on 10.04.2017.
 */
public class DateCheckValidator implements ConstraintValidator<DateCheck, Object> {

    @Override
    public void initialize(DateCheck dateCheck) {
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        try {
            return ((Date) o).after(new Date(System.currentTimeMillis()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
