package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<UserBean> login(String userName){
        return userMapper.loginByUsername(userName);
    }

    public void register(UserBean bean){
        userMapper.register(bean);
    }

    public List<UserBean> selectAll(){
        return userMapper.selectALL();}
}

