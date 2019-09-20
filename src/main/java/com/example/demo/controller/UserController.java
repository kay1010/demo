package com.example.demo.controller;

import com.example.demo.User;
import com.example.demo.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;


    @GetMapping("login")
    @ResponseBody
    public String login(HttpServletRequest request){
        logger.info("-------login---------");
        HttpSession session=request.getSession();
        session.setAttribute("id",session.getId());
        return "success!";

    }
    @GetMapping("list")
    @ResponseBody
    public List<User> getAllUser(HttpServletRequest request){
            logger.info("-------getAllUser---------");
            return userMapper.getUserInfo();

    }


}
