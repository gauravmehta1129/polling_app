package com.example.polling_app.controller;

import com.example.polling_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PreSignUp {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/user/checkUsernameAvailability")
    @ResponseBody
    public String checkAvailability(@RequestParam String username) {
        if (userRepository.existsByUsername(username)) {
            return "UNAVAILABLE";

        }
        return "Available";
    }
}
