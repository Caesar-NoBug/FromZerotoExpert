package com.caesar.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;

@RestController
public class MyController {

    @GetMapping("/FromZerotoExpert")
    public String start(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        boolean visited = false;
        Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if ("visited".equals(cookie.getName()))
                    visited = true;
            }
        }
        if(!visited){
            Cookie cookie = new Cookie("visited", "true");
            cookie.setMaxAge(60 * 60 * 24);
            httpServletResponse.addCookie(cookie);
        }

        String info = visited ? "嗨，欢迎您再次到 from zero to expert."
                : "嗨，欢迎您来到 from zero to expert.";

        return info;
    }
}
