package co.edu.practice.tse.controllers;

import co.edu.practice.tse.dtos.PrivateMemoryDto;
import co.edu.practice.tse.dtos.ProtectedMemoryDto;
import co.edu.practice.tse.services.ProtectedMemoryService;
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
public class ProtectedMemoryController {
    @Autowired
    private ProtectedMemoryService protectedMemoryService;

    private final Logger logger = LoggerFactory.getLogger(ProtectedMemoryController.class);

    @PostMapping("/post/protected-memory")
    public ResponseEntity<ProtectedMemoryDto> saveNewProtectedMemory(@RequestBody ProtectedMemoryDto protectedMemoryDto) {
        logger.info("Guardando Recuerdo Protegido: " + protectedMemoryDto);

        return new ResponseEntity(this.protectedMemoryService.saveNewProtectedMemory(protectedMemoryDto), HttpStatus.OK);
    }
}
