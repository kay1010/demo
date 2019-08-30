package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public interface UserMapper {

    //@Select("select * from user where id = #{id}")
    public Map getUserName(int id);

    @Insert("insert into user values(#{id},#{name})")
    public int addUser(@Param("id") int id, @Param("name") String name);
}
