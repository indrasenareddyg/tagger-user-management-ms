package com.centene.tagger.user.controller;

import com.centene.tagger.user.entity.User;
import com.centene.tagger.user.service.UserService;
import com.centene.tagger.user.vo.ResponseTemplateVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser method of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVo getUserById(@PathVariable("id") Long userId) {
        log.info("Inside getUserById method of UserController");
        return userService.getUserWithDepartment(userId);
    }
}
