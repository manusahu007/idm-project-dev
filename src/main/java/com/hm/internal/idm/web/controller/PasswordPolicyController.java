package com.hm.internal.idm.web.controller;


import com.hm.internal.idm.business.service.UserService;
import com.hm.internal.idm.web.model.ResponseObject;
import com.hm.internal.idm.web.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api")
@RestController
public class PasswordPolicyController {

    @Autowired
    private PasswordPolicyService passwordPolicyService;

    @PostMapping(value = "/passwordpolicies")
    public ResponseObject createPasswordPolicy(@RequestBody PasswordPolicyDto passwordPolicyDto) {
        ResponseObject response = new ResponseObject();
        boolean result = passwordPolicyService.createPasswordPolicy(PasswordPolicyDto);
        if (result) {
            response.setCode(201);
            response.setMessage("PasswordPolicy created successfully.");
            response.setApplicationErrorCode(0);
        } else {
            response.setCode(400);
            response.setMessage("PasswordPolicy already created.");
            response.setApplicationErrorCode(0);
        }
    }