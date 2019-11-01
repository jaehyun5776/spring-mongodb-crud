package com.golfzon.test;

import com.golfzon.test.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void test(){
        userRepository.deleteByName("test");
    }

    @Test
    public void test2(){
        log.debug(userRepository.findByAgeBetween(20, 30).toString());
    }
}
