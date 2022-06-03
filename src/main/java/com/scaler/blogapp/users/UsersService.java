package com.scaler.blogapp.users;


import com.scaler.blogapp.users.dtos.CreateUserRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    public UsersService(UsersRepository usersRepository, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    public UserEntity createUser(CreateUserRequest u) {
        UserEntity newUser = modelMapper.map(u, UserEntity.class);
        // TODO: encrypt and save password as well

        return usersRepository.save(newUser);
    }

    public UserEntity getUser(String username) {
        return usersRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
    }

    public UserEntity getUser(Long userId) {
        return usersRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }

    public UserEntity loginUser(String username, String password) {
        var user = usersRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
        // TODO: check the password
        return user;
    }


    public static class UserNotFoundException extends IllegalArgumentException {
        public UserNotFoundException(String username) {
            super("User with username: " + username + " not found");
        }

        public UserNotFoundException(Long userId) {
            super("User with id: " + userId + " not found");
        }
    }

}
