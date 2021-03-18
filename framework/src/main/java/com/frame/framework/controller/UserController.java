package com.frame.framework.controller;

import com.frame.framework.entity.User;
import com.frame.framework.service.UserService;
import com.frame.framework.utils.resultUtils.ResponseResultBody;
import com.frame.framework.utils.resultUtils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @program: framework
 * @description: user controller
 * @author: CodingLiOOT
 * @create: 2021-03-18 20:44
 * @version: 1.0
 **/
@Slf4j
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @ResponseResultBody
    @PostMapping(value = "/login")
    public Result login(@RequestBody User user){
        log.info("enter controller ");
        String token= userService.userLogin(user.getUsername(),user.getPassword());
        return Result.success(token);
        //return Result.success(token,"登录成功").toString();
    }

    @CrossOrigin
    @ResponseResultBody
    @PostMapping(value = "/test")
    @PreAuthorize("hasAnyRole('admin')")
    public String test(@RequestBody User user){
        log.info("enter controller ");
        return "hello";
    }



}
