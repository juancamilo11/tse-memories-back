package co.edu.practice.tse.mappers;

import co.edu.practice.tse.collections.User;
import co.edu.practice.tse.dtos.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User fromDtoToEntity(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .urlProfilePhoto(userDto.getUrlProfilePhoto())
                .build();
    }

    public UserDto fromEntityToDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .urlProfilePhoto(user.getUrlProfilePhoto())
                .build();
    }
}
