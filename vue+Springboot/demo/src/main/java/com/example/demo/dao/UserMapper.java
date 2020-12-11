package com.example.demo.dao;

import com.example.demo.entity.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user")
    List<UserBean> selectALL();

    @Select("select userName,password from user where userName = #{userName} and password = #{password} ")
    List<UserBean> getUserInfo(UserBean param);
}
