package com.wsq.hope.web.controller;

import com.wsq.hope.domain.biz.TestConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(ModelMap map,String user) {
        TestConfig t = new TestConfig();
        t.test();
        map.put("world", "world9");
        return "home/index";
    }
}
