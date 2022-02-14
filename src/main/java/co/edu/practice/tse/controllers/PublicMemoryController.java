package co.edu.practice.tse.controllers;

import co.edu.practice.tse.dtos.PublicMemoryDto;
import co.edu.practice.tse.services.PublicMemoryService;
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
public class PublicMemoryController {
    @Autowired
    private PublicMemoryService publicMemoryService;
    private final Logger logger = LoggerFactory.getLogger(PublicMemoryController.class);

    @PostMapping("/post/public-memory")
    public ResponseEntity<PublicMemoryDto> saveNewPublicMemory(@RequestBody PublicMemoryDto publicMemoryDto) {
        logger.info("[PublicMemory] POST Recuerdo Público");
        return new ResponseEntity(this.publicMemoryService.saveNewPublicMemory(publicMemoryDto), HttpStatus.OK);
    }
}
