package com.kevin.linguatrack.user.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.kevin.linguatrack.user.dtos.UserRequest;
import com.kevin.linguatrack.user.dtos.UserResponse;
import com.kevin.linguatrack.user.model.User;

@Component
public class UserMapper {

    public User toUser(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return user;
    }

    public UserResponse toResponse(User user) {

        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getCreatedAt());
    }

    public List<UserResponse> tResponseList(List<User> users) {

        return users.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
