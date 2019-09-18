package com.example.demo.service.Impl;

import com.example.demo.dao.MongoDBTestDao;
import com.example.demo.entity.User;
import com.example.demo.service.IMongoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: demo
 * @BelongsPackage: com.example.demo.service.Impl
 * @Author: lhb
 * @CreateTime: 2019-09-18 11:04
 * @Description:
 */
@Service
public class MongoTestImpl implements IMongoTest {

    @Autowired
    private MongoDBTestDao mongoDBTestDao;

    @Override
    public String insertUser() {
        User user = new User();
        user.setId(11);
        user.setAge(33);
        user.setName("name");
        mongoDBTestDao.insertUser(user);
        return "success";
    }

    @Override
    public User findUserByName() {
        User user = mongoDBTestDao.findUserByName("name");
        System.out.println("name is " + user);
        return user;
    }

    @Override
    public String updateUser() {
        User user = new User();
        user.setId(11);
        user.setAge(44);
        user.setName("test2");
        mongoDBTestDao.updateUser(user);
        return "success";
    }

    @Override
    public String deleteUserById() {
        mongoDBTestDao.deleteUserById(11);
        return "success";
    }
}
