package com.huziii.demo.project.simple.controller;

import com.alibaba.fastjson.JSONObject;
import com.huziii.demo.project.simple.bean.User;
import com.huziii.demo.project.simple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private UserService service;

    @Autowired
    public LoginController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public String login(String name, String password) {
        JSONObject json = new JSONObject();
        User user = service.login(name, password);
        if (user != null) {
            json.put("result", true);
            json.put("object", JSONObject.toJSONString(user));
        } else {
            json.put("result", false);
        }
        return json.toString();
    }

}
