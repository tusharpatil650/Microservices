package com.tom.user.controller;

import com.tom.user.entity.User;
import com.tom.user.service.UserService;
import com.tom.user.vo.ResponseTemplateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveDepartment(@RequestBody User user) {
        log.info("Inside saveUser method of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVo getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment method of UserController");
        return userService.getUserWithDepartment(userId);

    }
}
