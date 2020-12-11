package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.UserBean;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/")
public class UserLogInController {

    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping(value = "test")
    public String hello(){
        return "Hello,Spring";
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "api/loginUser")
    public ResponseEntity doLogin(@RequestBody UserBean user){
        //response.setHeader("Access-Control-Allow-Origin","http://localhost:8080");
        //System.out.println(user.getUserName()+user.getPassword());
        List<UserBean> userBean=userService.login(user);
        if(userBean.size()==0){
            Map<String,Object> map=new HashMap<>();
            map.put("code",1);
            map.put("msg","用户名或密码错误");
            map.put("data",user);
            return ResponseEntity.status(401).body(map);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","登陆成功");
        map.put("data",user);
        return ResponseEntity.ok(map);
    }




}
