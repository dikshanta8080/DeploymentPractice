package com.acharya.dikshanta.DeploymentPractice.controller;

import com.acharya.dikshanta.DeploymentPractice.dto.request.UserCreateRequest;
import com.acharya.dikshanta.DeploymentPractice.dto.response.UserResponse;
import com.acharya.dikshanta.DeploymentPractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @PostMapping
    public ResponseEntity<UserResponse> createUser(UserCreateRequest request){
        return ResponseEntity.ok().body(userService.createUser(request));
    }
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.getUserById(id));
    }
}
