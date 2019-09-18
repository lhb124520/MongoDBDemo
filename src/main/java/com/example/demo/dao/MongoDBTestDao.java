package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: demo
 * @BelongsPackage: com.example.demo.dao
 * @Author: lhb
 * @CreateTime: 2019-09-18 11:11
 * @Description:
 */
@Component
public class MongoDBTestDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     * insert()不能插入重复数据
     * save()若新增数据的主键已经存在，则会对当前已经存在的数据进行修改操作。
     */
    public void insertUser(User test) {
        mongoTemplate.insert(test);
    }

    /**
     * 根据用户名查询对象
     */
    public User findUserByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, User.class);
    }

    /**
     * 更新对象
     */
    public void updateUser(User test) {
        Query query = new Query(Criteria.where("id").is(test.getId()));
        Update update = new Update().set("age", test.getAge()).set("name", test.getName());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, User.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,TestEntity.class);
    }

    /**
     * 删除对象
     */
    public void deleteUserById(Integer id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, User.class);
    }

}
