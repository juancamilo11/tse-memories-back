package co.edu.practice.tse.controllers;

import co.edu.practice.tse.collections.User;
import co.edu.practice.tse.dtos.UserDto;
import co.edu.practice.tse.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/post/user")
    public ResponseEntity<UserDto> saveNewUser(@RequestBody UserDto userDto){
        logger.info("Guardando usuario: " + userDto);

        return new ResponseEntity(this.userService.saveNewUser(userDto), HttpStatus.OK);
    }
}
