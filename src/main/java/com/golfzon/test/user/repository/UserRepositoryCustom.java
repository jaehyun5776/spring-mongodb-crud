package com.golfzon.test.user.repository;

import com.golfzon.test.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserRepositoryCustom {

    List<User> getUserByAddress(String address);
    Page<User> findPageableAll(Pageable pageable);
    List<User> getUserByQueryDSL();

}
