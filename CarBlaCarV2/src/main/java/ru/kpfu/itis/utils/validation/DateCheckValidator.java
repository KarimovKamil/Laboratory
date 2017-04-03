package ru.kpfu.itis.utils.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kamil Karimov on 31.03.2017.
 */
public class DateCheckValidator implements ConstraintValidator<DateCheck, Object> {

    @Override
    public void initialize(DateCheck dateCheck) {
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        try {
            Date dateFromString = new SimpleDateFormat("dd.MM.yyyy HH:mm").parse((String) o);
            return dateFromString != null && dateFromString.getTime() >= System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
