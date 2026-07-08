package com.acharya.dikshanta.DeploymentPractice.mapper;

import com.acharya.dikshanta.DeploymentPractice.dto.request.UserCreateRequest;
import com.acharya.dikshanta.DeploymentPractice.dto.response.UserResponse;
import com.acharya.dikshanta.DeploymentPractice.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserCreateRequest request){
        return User.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }
    public UserResponse toResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }


}
