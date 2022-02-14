package co.edu.practice.tse.services;

import co.edu.practice.tse.dtos.UserDto;
import co.edu.practice.tse.mappers.UserMapper;
import co.edu.practice.tse.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    public UserDto saveNewUser(UserDto userDto){
        return this.userMapper
                .fromEntityToDto(this.userRepository
                        .save(this.userMapper
                                .fromDtoToEntity(userDto)));
    }
}
