package co.edu.practice.tse.controllers;

import co.edu.practice.tse.dtos.PrivateMemoryDto;
import co.edu.practice.tse.services.GeneralMemoryServiceImpl;
import co.edu.practice.tse.services.MailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "https://tse-memories.web.app/")
public class GeneralMemoryController {

    private final MailServiceImpl mailServiceImpl;
    private final Logger logger = LoggerFactory.getLogger(GeneralMemoryController.class);


    @Autowired
    private final GeneralMemoryServiceImpl generalMemoryService;

    @GetMapping("/get/all-memories/{userId}")
    public ResponseEntity<List<PrivateMemoryDto>> getAllUserMemories(@PathVariable("userId") String userId) {
        logger.info("[GeneralController] GET All memories");

        return new ResponseEntity(this.generalMemoryService.getAllUserMemories(userId), HttpStatus.OK);
    }

    @PostMapping("/post/send-mail/{memoryId}/{senderName}/{email}")
    public ResponseEntity<String> sendMessageForMemorySharing(@PathVariable("memoryId") String memoryId, @PathVariable("senderName") String senderName,@PathVariable("email")String email) {
        logger.info("[GeneralController] POST Send Message For Memory Sharing");
        String messageResult = this.mailServiceImpl.sendMessageForMemorySharing(memoryId, senderName, email);
        return new ResponseEntity(messageResult, messageResult.length() > 0 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}