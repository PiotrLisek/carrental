package com.carrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

        @GetMapping("/logout")
        public String logoutForm() {
            return "logout";
        }


}
