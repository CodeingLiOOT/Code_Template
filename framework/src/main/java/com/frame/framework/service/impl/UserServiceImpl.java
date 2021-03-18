package com.frame.framework.service.impl;

import com.frame.framework.entity.User;
import com.frame.framework.mapper.UserMapper;
import com.frame.framework.service.UserService;
import com.frame.framework.utils.exceptionHandler.exception.DefinitionException;
import com.frame.framework.utils.exceptionHandler.exception.ErrorEnum;
import com.frame.framework.utils.token.JWTUtils;
import com.frame.framework.utils.token.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;


/**
 * @program: framework
 * @description: user service impl
 * @author: CodingLiOOT
 * @create: 2021-03-18 20:19
 * @version: 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtUserServiceImpl jwtUserService;
    @Override
    public String userLogin(String username,String password) {
        User user=userMapper.selectUserByUserName(username);
        if(user==null||!password.equals(user.getPassword())){
            throw new DefinitionException(ErrorEnum.ERROR_NICKNAME_OR_PASSWORD);
        }

        JwtUser userDetails = (JwtUser)jwtUserService.loadUserByUsername(username);
        String token= jwtUtils.generateToken(userDetails);
        return token;
    }

    @Override
    public void register(User user) {

    }
}
