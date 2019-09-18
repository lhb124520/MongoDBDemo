package com.example.demo.service;

import com.example.demo.entity.User;

/**
 * @BelongsProject: demo
 * @BelongsPackage: com.example.demo.service
 * @Author: lhb
 * @CreateTime: 2019-09-18 11:21
 * @Description: ${Description}
 */
public interface IMongoTest {
    String insertUser();

    User findUserByName();

    String updateUser();

    String deleteUserById();
}
