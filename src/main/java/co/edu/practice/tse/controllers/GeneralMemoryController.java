package co.edu.practice.tse.controllers;

import co.edu.practice.tse.dtos.PrivateMemoryDto;
import co.edu.practice.tse.services.GeneralMemoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class GeneralMemoryController {

    private final Logger logger = LoggerFactory.getLogger(GeneralMemoryController.class);


    @Autowired
    private final GeneralMemoryServiceImpl generalMemoryService;

    @GetMapping("/get/all-memories/{userId}")
    public ResponseEntity<List<PrivateMemoryDto>> getAllUserMemories(@PathVariable("userId")String userId) {
        logger.info("[GeneralController] GET All memories");

        return new ResponseEntity(this.generalMemoryService.getAllUserMemories(userId), HttpStatus.OK);
    }

}