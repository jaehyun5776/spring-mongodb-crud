package com.example.demo.user.web;

import com.example.demo.user.domain.User;
import com.example.demo.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public void getAllUser(){
        log.debug("[all] "+userRepository.findAll().toString());
    }

    @RequestMapping(value = "/getUserByName", method = RequestMethod.GET)
    public void getUserByName(@RequestParam("name") String name){
        log.debug("[getUserByName] " + userRepository.findByName(name).toString());
    }

    @RequestMapping(value = "/getUserByAddress", method = RequestMethod.GET)
    public String getUserByAddress(@RequestParam("address") String address) {
        log.debug("[getUserByAddress] " + userRepository.getUserByAddress(address).toString());
        return userRepository.getUserByAddress(address).toString();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void insertUser(@RequestBody User user){
        userRepository.save(user);
        log.debug("[insert] " + userRepository.findAll().toString());
    }

    @RequestMapping(value = "/deleteByName/{name}", method = RequestMethod.DELETE)
    public void deleteByName(@PathVariable("name") String name){
        userRepository.deleteByName(name);
        log.debug("[delete] "+userRepository.findAll().toString());
    }

    @RequestMapping(value = "/getList/page/{page}/size/{size}", method = RequestMethod.GET)
    public String getListPageable(@PathVariable("page") int page,
                                  @PathVariable("size") int size){
        Pageable pageable = PageRequest.of(page - 1, size);

        log.debug("[getListPageable] "+userRepository.findPageableAll(pageable).getContent());

        return userRepository.findPageableAll(pageable).getContent().toString();
    }

    @RequestMapping(value = "/queryDsl", method = RequestMethod.GET)
    public String getUserByQueryDSL(){
        List<User> list = userRepository.getUserByQueryDSL();
        log.debug("[getUserByQueryDSL] " + list.toString());
        return list.toString();
    }
}
