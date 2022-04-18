package com.cx.service;

import com.cx.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAllUsers();
}
