package co.edu.practice.tse.controllers;

import co.edu.practice.tse.collections.User;
import co.edu.practice.tse.dtos.UserDto;
import co.edu.practice.tse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public UserDto saveNewUser(@RequestBody UserDto userDto){
        return this.userService.saveNewUser(userDto);
    }
}
