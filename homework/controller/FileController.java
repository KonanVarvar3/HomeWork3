package com.homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class FileController {

    @GetMapping("/uploadFile")
    public String getFile() {

        return "uploadFile";
    }

    @PostMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) {

        String name = file.getName();

        if (!file.isEmpty()) {
            try (FileOutputStream fos = new FileOutputStream("user.txt", true)) {

                byte[] buffer = file.getBytes();
                fos.write(buffer, 0, buffer.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "You successfully uploaded file";
        } else {
            return "You failed to upload " + name + " because the file was empty!";
        }
    }

}

