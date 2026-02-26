package com.kevin.linguatrack.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.linguatrack.user.dtos.UserRequest;
import com.kevin.linguatrack.user.dtos.UserResponse;
import com.kevin.linguatrack.user.mapper.UserMapper;
import com.kevin.linguatrack.user.model.User;
import com.kevin.linguatrack.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Transactional
    public UserResponse saveUser(UserRequest request) {

        userRepository.findByEmail(request.getEmail()).ifPresent(u -> {
            throw new RuntimeException("El usuario ya existe");
        });

        try {
            
            User user = userMapper.toUser(request);
            user.setRole("User");
            
            User savedUser = userRepository.save(user);
            
            return userMapper.toResponse(savedUser);

        } catch (Exception e) {
            log.error("Error guardando usuario", e);
            throw new RuntimeException("Error interno");
        }

    }

    @Transactional(readOnly = true)
    public List<UserResponse> getAllUsers(){
        try {
            
            List<User> users = userRepository.findAll();
            return userMapper.tResponseList(users);

        } catch (Exception e) {
            log.error("Error obteniendo usuario", e);
            throw new RuntimeException("Error interno");
        }
    }
}
