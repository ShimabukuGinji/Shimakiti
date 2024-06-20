// RUsersController
package com.example.shimakiti.controller;

import com.example.shimakiti.Service.UsersService;
import com.example.shimakiti.entity.Users;
import com.example.shimakiti.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class RUsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<List<Users>> display() {
        System.out.println("1");
        try {
            List<Users> userList = usersService.fingAll();
            return new ResponseEntity<>(userList, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
