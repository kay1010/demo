package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("{id}")
    @ResponseBody
    public Map getUser(@PathVariable int id){
        return userMapper.getUserName(id);

    }

    @GetMapping("addUser")
    @ResponseBody
    public int addUser(String name,int id){
        return userMapper.addUser(id,name);

    }
}
