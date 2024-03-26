package com.vizhu.vizhu.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInRequest {
    @NotBlank(message = "Login cannot be empty")
    String login;
    @NotBlank(message = "Password cannot be empty")
    String password;
}
