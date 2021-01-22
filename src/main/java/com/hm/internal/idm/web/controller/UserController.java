package com.hm.internal.idm.web.controller;

import com.hm.internal.idm.business.service.UserService;
import com.hm.internal.idm.dataaccess.entity.User;
import com.hm.internal.idm.web.model.ResponseObject;
import com.hm.internal.idm.web.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/users")
    public ResponseObject createUser(@RequestBody UserDto userDto) {
        ResponseObject response = new ResponseObject();
        boolean result = userService.createUser(userDto);
        if (result) {
            response.setCode(201);
            response.setMessage("User created successfully.");
            response.setApplicationErrorCode(0);
        } else {
            response.setCode(400);
            response.setMessage("User already created.");
            response.setApplicationErrorCode(0);
        }

        return response;
    }

    @GetMapping(value = "/users/list")
    public List<User> getUsers() {
        List<User> users = userService.getUsers();
        return users;
    }

    @DeleteMapping(value ="/users/{id}")
    public ResponseObject deleteByUserId(@PathVariable Long id) {
        ResponseObject response = new ResponseObject();
        boolean result = userService.deleteByUserId(id);
        if (result) {
            response.setCode(200);
            response.setMessage("User deleted successfully.");
            response.setApplicationErrorCode(1114);
        } else {
            response.setCode(400);
            response.setMessage("User already created.");
            response.setApplicationErrorCode(0);
        }
        return response;
    }

}
