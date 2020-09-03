package com.qa.fit.rest;

import com.qa.fit.domain.Users;
import com.qa.fit.dto.UsersDTO;
import com.qa.fit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService uService;

    @Autowired
    public UserController(UserService uService){
        this.uService = uService;
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UsersDTO>> getAllUsers(){
        return  ResponseEntity.ok( this.uService.readAllUsers());
    }

    @PostMapping("/createUser")
    public ResponseEntity<UsersDTO> createUser(@RequestBody Users users){
        return new ResponseEntity<UsersDTO>(this.uService.createUser(users), HttpStatus.CREATED);

    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        return this.uService.deleteUserById(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UsersDTO> getUserById(@PathVariable Long id){
        return ResponseEntity.ok( this.uService.findUserById(id));
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UsersDTO> updateUser(@PathVariable Long id, @RequestBody Users users){
        return ResponseEntity.ok(this.uService.updateUser(id, users));
    }
}
