package com.travelBoard.controller;

import com.travelBoard.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @PostMapping("/save")
    public String save(User user) {
        return "registerInfo";
    }
}
