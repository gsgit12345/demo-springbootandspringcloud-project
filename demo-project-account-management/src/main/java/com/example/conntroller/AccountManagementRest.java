package com.example.conntroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountManagementRest {

    @GetMapping("/status")
    public  String  statusCheck()
    {
        return "workinng";
    }
}
