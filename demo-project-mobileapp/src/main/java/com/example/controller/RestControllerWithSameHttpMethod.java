package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerWithSameHttpMethod {
    @RequestMapping(
            value = "/ex/foos/multiple",
            method = { RequestMethod.PUT, RequestMethod.POST }
    )
    @ResponseBody
    public String putAndPostFoos() {
        return "Advanced - PUT and POST within single method";
    }
    @RequestMapping(
            value = "*",
            method = { RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String allFallback() {
        return "Fallback for All Requests";
    }

}
