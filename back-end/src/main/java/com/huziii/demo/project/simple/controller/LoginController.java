package com.huziii.demo.project.simple.controller;

import com.alibaba.fastjson.JSONObject;
import com.huziii.demo.project.simple.bean.User;
import com.huziii.demo.project.simple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    private UserService service;

    @Autowired
    public LoginController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public String login(@RequestBody JSONObject jsonParam) {
        JSONObject json = new JSONObject();
        User user = service.login(jsonParam.getString("name"), jsonParam.getString("password"));
        if (user != null) {
            json.put("result", true);
            json.put("userId", user.getId());
            json.put("userType", user.getType());
        } else {
            json.put("result", false);
        }
        return json.toString();
    }

}
