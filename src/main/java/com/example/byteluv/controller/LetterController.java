package com.example.byteluv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MrWang98
 * @Date 2021/11/25 10:17
 **/
@RestController
public class LetterController {

    @GetMapping("/getLetter")
    public String getLetter(){
        return "succes";
    }
}
