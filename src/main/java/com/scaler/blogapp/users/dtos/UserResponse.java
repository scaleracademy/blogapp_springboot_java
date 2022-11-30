package com.scaler.blogapp.users.dtos;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String bio;
    private String image;
    private String token;
}
