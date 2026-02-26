package com.kevin.linguatrack.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.linguatrack.user.dtos.UserRequest;
import com.kevin.linguatrack.user.dtos.UserResponse;
import com.kevin.linguatrack.user.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(
            userService.saveUser(request)
        );
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        
        return ResponseEntity.ok(userService.getAllUsers());
    }
    
}
