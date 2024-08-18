package com.example.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class AmbiguousPathMapping {

    @GetMapping(value = "foos/duplicate" )
    public String duplicate() {
        return "Duplicate";
    }

    /*@GetMapping(value = "foos/duplicate" )
    public String duplicateEx() {
        return "Duplicate";
    }*/
    //above two method will give ambigous error mapping

    //The code snippet below will not result in ambiguous mapping error because both methods return different content types:
    @GetMapping(value = "foos/duplicate", produces = MediaType.APPLICATION_XML_VALUE)
    public String duplicateXml() {
        return "<message>Duplicate</message>";
    }

    @GetMapping(value = "foos/duplicate", produces = MediaType.APPLICATION_JSON_VALUE)
    public String duplicateJson() {
        return "{\"message\":\"Duplicate\"}";
    }


}
