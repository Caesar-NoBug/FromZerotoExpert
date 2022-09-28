package com.caesar.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("FromZerotoExpert")
public class MyController {

    @GetMapping
    public String start(){
        //麻了
        return "index.html";
    }
}
