package cn.toskey.iboot.module.admin.controller;

import cn.toskey.iboot.module.admin.model.User;
import cn.toskey.iboot.module.admin.service.IUserService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String all() {
        List<User> list = userService.findAllUser();
        return JSONArray.toJSONString(list);
    }

}
