package com.caesar.Controller;

import com.caesar.Domain.User;
import com.caesar.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/FromZerotoExpert")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
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

    @PostMapping("/register")
    public String register(@RequestBody User user){
        String info = userService.register(user) ? "注册成功！" : "用户名已存在！";
        return info;
    }
}
