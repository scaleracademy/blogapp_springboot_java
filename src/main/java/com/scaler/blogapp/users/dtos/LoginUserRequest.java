package com.scaler.blogapp.users.dtos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class LoginUserRequest {
    @NonNull
    private String username;
    @NonNull
    private String password;
}
