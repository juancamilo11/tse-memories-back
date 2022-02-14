package co.edu.practice.tse.controllers;

import co.edu.practice.tse.dtos.UserDto;
import co.edu.practice.tse.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/post/user")
    public ResponseEntity<UserDto> saveNewUser(@RequestBody UserDto userDto){
        logger.info("[User] POST User");
        return new ResponseEntity(this.userService.saveNewUser(userDto), HttpStatus.OK);
    }
}
