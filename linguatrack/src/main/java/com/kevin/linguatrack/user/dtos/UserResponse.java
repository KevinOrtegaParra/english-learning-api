package com.kevin.linguatrack.user.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
    
    private UUID id;
    
    private String name;
    
    private String email;
    
    private String role;

    private LocalDateTime createdAt;
}
