package com.homework;

import com.homework.model.Form;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class FormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Form.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Form form = (Form) o;

        String age = Integer.toString(form.getAge());

        if (!(Pattern.matches("\\d{1,2}", age))) {
            errors.rejectValue("age", "age.notValid", "Incorrect age!");
        }

        String salary = Double.toString(form.getSalary());
        if (!(Pattern.matches("\\d+\\.\\d+|\\d+|\\d+,\\d+", salary))) {
            errors.rejectValue("salary", "salary.notValid", "Incorrect salary!");
        }

        String email = form.getEmail();
        if (!(Pattern.matches(".+@mail\\.ru|.+@gmail\\.ru", email))) {
            errors.rejectValue("email", "email.notValid", "Incorrect email!");
        }
    }
}
