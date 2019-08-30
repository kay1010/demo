package com.example.demo.controller;

import com.example.demo.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
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

    @GetMapping("list")
    @ResponseBody
    public List<User> getAllUser(HttpServletRequest request){
        HttpSession session=request.getSession();
        if(session.getAttribute("name")!=null&& session.getAttribute("name").equals("fkk")){
            return userMapper.getUserInfo();
        }else {
            throw new RuntimeException();
        }


    }

    @GetMapping("addUser")
    @ResponseBody
    public int addUser(String name,int id,HttpServletRequest request){
        HttpSession session=request.getSession();
        session.setAttribute("name","fkk");
        return userMapper.addUser(id,name);

    }
}
