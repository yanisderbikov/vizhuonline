package com.vizhu.vizhu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SignUpRequest extends SignInRequest{
    private String firstName;
    private String lastName;
}
