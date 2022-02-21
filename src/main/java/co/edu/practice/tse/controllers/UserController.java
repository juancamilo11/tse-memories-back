package co.edu.practice.tse.controllers;

import co.edu.practice.tse.dtos.UserDto;
import co.edu.practice.tse.services.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://tse-memories.firebaseapp.com/")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/post/user")
    public ResponseEntity<UserDto> saveNewUser(@RequestBody UserDto userDto){
        logger.info("[User] POST User");
        return new ResponseEntity(this.userService.saveNewUser(userDto), HttpStatus.OK);
    }

    @GetMapping("/get/user/{userId}")
    public ResponseEntity<UserDto> getUserInfoById(@PathVariable String userId) {
        logger.info("[User] GET User");
        return new ResponseEntity(this.userService.getUserInfoById(userId),HttpStatus.OK);
    }

    @PostMapping("/get/users-list")
    public ResponseEntity<List<UserDto>> getUserListInfoByUserIdList(@RequestBody List<String> userIdList){
        logger.info("[User] GET User List Info By UserIdList");
        return new ResponseEntity(this.userService.getUsersInfoByUserIdList(userIdList), HttpStatus.OK);
    }
}