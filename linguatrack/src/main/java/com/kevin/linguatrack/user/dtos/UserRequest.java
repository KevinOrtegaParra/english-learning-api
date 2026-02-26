package com.kevin.linguatrack.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    
    @Email(message = "Correo inválido")
    @NotBlank(message = "El correo es obligatori")
    @Size(max = 150)
    private String email;

    @NotBlank(message = "La contrseña es obligatori")
    private String password;
}
