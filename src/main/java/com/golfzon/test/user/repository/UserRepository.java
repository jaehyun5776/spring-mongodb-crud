package com.golfzon.test.user.repository;

import com.golfzon.test.user.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String>, QuerydslPredicateExecutor<User>, UserRepositoryCustom {

    List<User> findAll();
    User findByName(String name);
    void deleteByName(String name);
    List<User> findByAgeBetween(int ageGT, int ageLT);
}
