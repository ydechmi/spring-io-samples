package com.yd.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yacine on 25/05/2015.
 */
@Controller
public class WelcomeController {

    @RequestMapping("/spring-boot-demo/welcome")
    public String welcome() {

        return "/welcome.html";
    }
}
