package com.kevin.linguatrack.user.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue
    @UuidGenerator
    UUID id;

    @Column(nullable = false)
    String name;

    @Column(unique = true, nullable = false, length = 150)
    String email;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    String role;

    LocalDateTime createdAt;

    @PrePersist
    void onCreate(){
        createdAt = LocalDateTime.now();
    }
}
