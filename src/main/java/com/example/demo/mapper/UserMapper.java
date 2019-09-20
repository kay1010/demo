package com.example.demo.mapper;

import com.example.demo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
public interface UserMapper {

    //@Select("select * from user where id = #{id}")
    public Map getUser(String name,String password);

    @Insert("insert into user(name,password,address,role) values(#{user.name},#{user.password},#{user.address},#{user.role})")
    public int addUser(@Param("user") User user);

    @Select("select * from user")
    public List<User> getUserInfo();
}
