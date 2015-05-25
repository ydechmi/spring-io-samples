package com.yd.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ydechmi on 25/05/2015.
 */
@RestController
public class DemoController {

    @RequestMapping("/")
    public String index() {
        return "Spring boot's demo applications";
    }
}
