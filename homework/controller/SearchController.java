package com.homework.controller;

import com.homework.model.Form;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Pattern;

@Controller
public class SearchController {

    @GetMapping("/search")
    public String search(Model model, HttpServletRequest req) {

        model.addAttribute("form", new Form());
        return "search";
    }

    public String[] readingUserRecords(){
        String [] words = new String[0];
        try (FileReader fr = new FileReader("user.txt");
             BufferedReader reader = new BufferedReader(fr)) {

            String line = reader.readLine();
            String inf = "";

            while (line != null) {
                inf = inf.concat(line + '\n');
                line = reader.readLine();
            }

            words = inf.split("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    public boolean searchUser(String [] words, Form form, String lastNameValue, String nameValue ){

        int i = 0;

        while (i < words.length) {
            if (Pattern.matches(lastNameValue + "\\|" + nameValue + "\\|.+\\|.+\\|.+\\|.+\\|.+", words[i])) {

                String[] str = words[i].split("\\|");

                form.setLastName(str[0]);
                form.setName(str[1]);
                form.setMiddleName(str[2]);
                form.setAge(new Integer(str[3]));
                form.setSalary(new Double(str[4]));
                form.setEmail(str[5]);
                form.setWorkAddress(str[6]);
                return true;
            }
            i++;
        }
        return false;
    }

    String browser;
    @PostMapping("/search")
    public String resultSearch(@ModelAttribute Form form, HttpServletRequest req, HttpServletResponse resp) {

        String lastNameValue = req.getParameter("lastName");
        String nameValue = req.getParameter("name");

        form.setBrowser(req.getHeader("User-Agent"));

        form.setDate(new Date());

        if(searchUser(readingUserRecords(),form,lastNameValue,nameValue)){
            return "searchResult";
        }

        return "notFound";
    }
}
