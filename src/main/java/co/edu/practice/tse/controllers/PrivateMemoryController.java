package co.edu.practice.tse.controllers;

import co.edu.practice.tse.dtos.PrivateMemoryDto;
import co.edu.practice.tse.services.PrivateMemoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PrivateMemoryController {
    @Autowired
    private PrivateMemoryServiceImpl privateMemoryService;
    private final Logger logger = LoggerFactory.getLogger(PrivateMemoryController.class);

    @PostMapping("/post/private-memory")
    public ResponseEntity<PrivateMemoryDto> saveNewPrivateMemory(@RequestBody PrivateMemoryDto privateMemoryDto) {
        logger.info("[PrivateMemory] POST Recuerdo Privado");
        return new ResponseEntity(this.privateMemoryService.saveNewPrivateMemory(privateMemoryDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/private-memory/{userId}/{memoryId}")
    public ResponseEntity<String> deletePrivateMemory(@PathVariable("memoryId") String memoryId, @PathVariable("userId") String userId) {
        logger.info("[PrivateMemory] DELETE Recuerdo Privado");
        return this.privateMemoryService.deletePrivateMemoryById(memoryId, userId);
    }
}
