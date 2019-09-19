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
    public Map getUserName(int id);

    @Insert("insert into user(name) values(#{name})")
    public int addUser( @Param("name") String name);

    @Select("select * from user")
    public List<User> getUserInfo();
}
