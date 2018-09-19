package cn.toskey.iboot.module.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/router")
public class RouterController {

    @GetMapping("/index")
    public String index() {
        return "/index";
    }

}
