package com.example.controller;

import com.example.exceptionhandler.UserServiceException;
import com.example.model.request.UpdateUserRequest;
import com.example.model.request.UserRequest;
import com.example.model.response.UserResponse;
import com.example.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService service;
    Map<String, UserRequest> userRequestMap;

    @GetMapping(path = "/{userid}")
    public ResponseEntity<UserRequest> getUser(@PathVariable String userid) {
        System.out.println(userid);
        // String str=null;
        //int len=str.length();//generate exception
        if (true)
            throw new UserServiceException("i am user srvice exception");
        if (userRequestMap != null) {
            return new ResponseEntity<>(userRequestMap.get(userid), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping
    public String requestParam(@RequestParam("page") String userid, @RequestParam("limit") String limit2) {
        return "getuser has been called userid:" + userid + ":limit is:" + limit2;
    }
    // http://localhost:8080/user/123  //this is example of path parameter
    // /client/{clientId}/department/{departmentId}/employees


    @GetMapping("/demo")
    public String requestParamDemo(@RequestParam(value = "page1", defaultValue = "40") String page1, @RequestParam(value = "limit1", defaultValue = "100") String limit2) {
        return "getuser has been called userid:" + page1 + ":limit is:" + limit2;
    }
    //http://localhost:8080/user/demo?page1=12    ==it will work

    @GetMapping(value = "/demo2", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserResponse getUserObject() {
        UserResponse response = new UserResponse();
        response.setUserId("hello");
        return response;
    }

    @GetMapping(value = "/demo3", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponse> getUser() {
        UserResponse response = new UserResponse();
        response.setUserId("how");
        return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
    }

    @PostMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRequest> createUser(@Valid @RequestBody UserRequest request) {
        UserRequest returnVal = service.createUser(request);
        return new ResponseEntity<UserRequest>(returnVal, HttpStatus.OK);

    }

    @PutMapping(path = "/{userid}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})

    public UserRequest updateUser(@PathVariable("userid") String userid, UpdateUserRequest request) {

        UserRequest requestOb = userRequestMap.get(userid);
        requestOb.setName(request.getName());
        requestOb.setUserId(request.getUserId());
        userRequestMap.put(userid, requestOb);
        return requestOb;

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {

        userRequestMap.remove(id);
        return ResponseEntity.noContent().build();

    }
}
