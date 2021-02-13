package com.homework.controller;

import com.homework.MyConstants;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EmailController {
    @Autowired
    public JavaMailSender emailSender;

    @GetMapping("/sendEmail")
    public String getEmailForm(Model model, HttpServletRequest req) {

        model.addAttribute("simpleMailMessage", new SimpleMailMessage());
        return "sendEmail";
    }

    @ResponseBody
    @PostMapping("/sendEmail")
    public String sendSimpleEmail(@ModelAttribute SimpleMailMessage simpleMailMessage, HttpServletRequest req) {

        simpleMailMessage.setTo(MyConstants.FRIEND_EMAIL);
        simpleMailMessage.setSubject("Test Simple Email");
        simpleMailMessage.setText(req.getParameter("text"));

        this.emailSender.send(simpleMailMessage);

        return "Email have been sending!";
    }
}
