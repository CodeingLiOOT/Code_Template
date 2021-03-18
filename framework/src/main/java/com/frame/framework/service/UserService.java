package com.frame.framework.service;

import com.frame.framework.entity.User;

public interface UserService {

    String userLogin(String username,String password);

    void register(User user);
}
