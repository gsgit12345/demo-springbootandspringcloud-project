package com.example.userconntroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserConntrolerRest {

    @GetMapping(path = "/status")
    public String statusCheck()
    {
        return "working";
    }
}
