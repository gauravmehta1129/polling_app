package com.example.polling_app.payload;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
@Data
public class LoginRequest {
    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;

}
