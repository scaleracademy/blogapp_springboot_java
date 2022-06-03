package com.scaler.blogapp.users;


import com.scaler.blogapp.users.dtos.CreateUserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase()
public class UsersServiceTests {

    @Autowired
    UsersService usersService;

    @Test
    void can_create_users() {

        var user = usersService.createUser(new CreateUserRequest(
                "john",
                "pass123",
                "john@blog.com"
        ));

        Assertions.assertNotNull(user);
        Assertions.assertEquals("john", user.getUsername());

    }
}
