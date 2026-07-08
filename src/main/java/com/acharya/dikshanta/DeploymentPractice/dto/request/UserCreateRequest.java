package com.acharya.dikshanta.DeploymentPractice.dto.request;

public record UserCreateRequest(
        String name,
        String email,
        String password
) {
}
