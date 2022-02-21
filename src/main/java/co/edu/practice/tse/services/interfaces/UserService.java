package co.edu.practice.tse.services.interfaces;

import co.edu.practice.tse.dtos.UserDto;

import java.util.List;

public interface UserService {
    UserDto saveNewUser(UserDto userDto);
    UserDto getUserInfoById(String userId);
    List<UserDto> getUsersInfoByUserIdList(List<String> userIdList);
}
