package com.acharya.dikshanta.DeploymentPractice.service;

import com.acharya.dikshanta.DeploymentPractice.dto.request.UserCreateRequest;
import com.acharya.dikshanta.DeploymentPractice.dto.response.UserResponse;
import com.acharya.dikshanta.DeploymentPractice.mapper.UserMapper;
import com.acharya.dikshanta.DeploymentPractice.model.User;
import com.acharya.dikshanta.DeploymentPractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    @Transactional
    public UserResponse createUser(UserCreateRequest request){
        if (userRepository.existsByEmail(request.email())){
            throw new RuntimeException("User already exists");
        }
        User user = userMapper.toEntity(request);
        return userMapper.toResponse(userRepository.save(user));
    }
    @Transactional(readOnly = true)
    public List<UserResponse> getAllUsers(){
        return userRepository.findAll().stream().map(userMapper::toResponse).toList();
    }
    public UserResponse getUserById(Long id){
        return userMapper.toResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
    }
}
