package co.edu.practice.tse.services;

import co.edu.practice.tse.collections.User;
import co.edu.practice.tse.dtos.UserDto;
import co.edu.practice.tse.mappers.UserMapper;
import co.edu.practice.tse.repositories.UserRepository;
import co.edu.practice.tse.services.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto saveNewUser(UserDto userDto){
        return this.userMapper
                .fromEntityToDto(this.userRepository
                        .save(this.userMapper
                                .fromDtoToEntity(userDto)));
    }

    @Override
    public UserDto getUserInfoById(String userId) {
        return this.userMapper.
                fromEntityToDto(this.userRepository.
                        findById(userId).orElse(User.builder().build()));
    }

    @Override
    public List<UserDto> getUsersInfoByUserIdList(List<String> userIdList) {
        List<UserDto> userDtoList = new ArrayList<>();
        this.userRepository.findAllById(userIdList).forEach(user -> userDtoList.add(this.userMapper.fromEntityToDto(user)));
        return userDtoList;
    }
}
