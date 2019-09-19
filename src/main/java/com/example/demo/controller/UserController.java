package com.example.demo.controller;

import com.example.demo.User;
import com.example.demo.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;

    @GetMapping("{id}")
    @ResponseBody
    public Map getUser(@PathVariable int id){
        return userMapper.getUserName(id);

    }

    @GetMapping("list")
    @ResponseBody
    public List<User> getAllUser(HttpServletRequest request){
            logger.info("-------getAllUser---------");
            return userMapper.getUserInfo();

    }

    @GetMapping("addUser")
    @ResponseBody
    public String addUser(String name){
         userMapper.addUser(name);

         return "the user added success";

    }
}
