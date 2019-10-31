package com.example.demo.user.repository.impl;

import com.example.demo.user.domain.User;
import com.example.demo.user.repository.UserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.support.QuerydslRepositorySupport;
import org.springframework.data.repository.support.PageableExecutionUtils;

import java.util.List;

import static com.example.demo.user.domain.dsl.QUser.user;

public class UserRepositoryImpl extends QuerydslRepositorySupport implements UserRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MongoOperations mongoOperations;

    public UserRepositoryImpl(MongoOperations operations) { super(operations); }


    @Override
    public List<User> getUserByAddress(String address) {

        Query query = new Query();
        query.addCriteria(Criteria.where("address").is(address));

        return mongoTemplate.find(query, User.class);
    }

    @Override
    public Page<User> findPageableAll(Pageable pageable) {

        Query query = new Query().with(pageable);
        List<User> list = mongoOperations.find(query, User.class);

        return PageableExecutionUtils.getPage(list, pageable, () -> mongoOperations.count(query, User.class));
    }

    @Override
    public List<User> getUserByQueryDSL() {

        return from(user).where(user.name.eq("test12")).fetch();
    }
}
