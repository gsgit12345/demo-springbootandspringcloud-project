package com.example.service.impl;

import com.example.model.request.UserRequest;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    Map<String, UserRequest> userRequestMap;

    @Override
    public UserRequest createUser(UserRequest request) {

        String userid = UUID.randomUUID().toString();

        UserRequest returnVal = new UserRequest();
        returnVal.setUserId(userid);
        returnVal.setEmail(request.getEmail());
        returnVal.setName(request.getName());
        returnVal.setPassword(request.getPassword());
        if (userRequestMap == null) {
            userRequestMap = new HashMap<>();
            userRequestMap.put(userid, returnVal);
        }
        System.out.println("in post request");
return  returnVal;
    }
}
