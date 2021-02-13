package com.homework.controller;

import com.homework.FormValidator;
import com.homework.model.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
public class FormController {

    @Autowired
    private FormValidator formValidator;

    @GetMapping("/form")
    public String form(Model model, HttpServletRequest req) {

        model.addAttribute("form", new Form());
        return "form";
    }

    public void write(String lastNameValue, String nameValue, String middleNameValue,
                      String ageValue, String salaryValue, String emailValue, String workAddressValue) {

        try (FileWriter writer = new FileWriter("user.txt", true)) {
            writer.write(lastNameValue
                    + '|' + nameValue
                    + '|' + middleNameValue
                    + '|' + ageValue
                    + '|' + salaryValue
                    + '|' + emailValue
                    + '|' + workAddressValue
                    + "\n\n");
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    @PostMapping("/form")
    public String formSubmit(@ModelAttribute Form form, HttpServletRequest req,
                             BindingResult result) {

        formValidator.validate(form, result);
        if (result.hasErrors()) {
            return "form";
        }

        String lastNameValue = req.getParameter("lastName");
        String nameValue = req.getParameter("name");
        String middleNameValue = req.getParameter("middleName");
        String ageValue = req.getParameter("age");
        String salaryValue = req.getParameter("salary");
        String emailValue = req.getParameter("email");
        String workAddressValue = req.getParameter("workAddress");

        write(lastNameValue, nameValue, middleNameValue, ageValue, salaryValue, emailValue, workAddressValue);

        return "data";
    }


}
