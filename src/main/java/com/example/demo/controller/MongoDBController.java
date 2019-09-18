package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.IMongoTest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: demo
 * @BelongsPackage: com.example.demo.controller
 * @Author: lhb
 * @CreateTime: 2019-09-18 11:04
 * @Description:
 */
@RestController
@Api(description = "MongoDB增删改查基本操作")
public class MongoDBController {
    @Autowired
    private IMongoTest iMongoTest;

    @PostMapping(value = "/insertUser")
    @ApiOperation(value = "插入一个用户", response = String.class)
    public String insertUser() {
        return iMongoTest.insertUser();
    }

    @PostMapping(value = "/findUserByName")
    @ApiOperation(value = "通过id查询用户", response = User.class)
    public User findUserByName() {
        return iMongoTest.findUserByName();
    }

    @PostMapping(value = "/updateUser")
    @ApiOperation(value = "更新用户", response = String.class)
    public String updateUser() {
        return iMongoTest.updateUser();
    }

    @PostMapping(value = "/deleteUserById")
    @ApiOperation(value = "删除用户", response = String.class)
    public String deleteUserById() {
        return iMongoTest.deleteUserById();
    }

}
