package co.edu.practice.tse.controllers;

import co.edu.practice.tse.dtos.ProtectedMemoryDto;
import co.edu.practice.tse.dtos.PublicMemoryDto;
import co.edu.practice.tse.dtos.helpers.VisualizationDto;
import co.edu.practice.tse.services.ProtectedMemoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://tse-memories.web.app/")
//@CrossOrigin(origins = "http://localhost:3000/")
public class ProtectedMemoryController {
    @Autowired
    private ProtectedMemoryServiceImpl protectedMemoryServiceImpl;
    private final Logger logger = LoggerFactory.getLogger(ProtectedMemoryController.class);

    @PostMapping("/post/protected-memory")
    public ResponseEntity<ProtectedMemoryDto> saveOrUpdateNewProtectedMemory(@RequestBody ProtectedMemoryDto protectedMemoryDto) {
        logger.info("[ProtectedMemory] POST Recuerdo Protegido");
        return new ResponseEntity(this.protectedMemoryServiceImpl.saveOrUpdateNewProtectedMemory(protectedMemoryDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/protected-memory/{userId}/{memoryId}")
    public ResponseEntity<String> deleteProtectedMemory(@PathVariable("memoryId") String memoryId, @PathVariable("userId") String userId) {
        logger.info("[ProtectedMemory] DELETE Recuerdo Protegido");
        return this.protectedMemoryServiceImpl.deleteProtectedMemoryById(memoryId, userId);
    }

    @PutMapping("/put/protected-memory/count-view/{memoryId}")
    public ResponseEntity<PublicMemoryDto> countProtectedMemoryView(@RequestBody VisualizationDto visualizationDto, @PathVariable("memoryId") String memoryId) {
        System.out.println(visualizationDto);
        System.out.println(memoryId);

        logger.info("[ProtectedMemory] PUT Registro de Visita a Recuerdo Protegido");
        return new ResponseEntity(this.protectedMemoryServiceImpl.registerProtectedMemoryView(memoryId, visualizationDto), HttpStatus.OK);
    }

    @GetMapping("/get/protected-memories/{userId}")
    public ResponseEntity<List<ProtectedMemoryDto>> getAllUserProtectedMemories(@PathVariable("userId") String userId) {
        logger.info("[PublicMemory] GET Todos los Recuerdos Protegidos");
        return new ResponseEntity(this.protectedMemoryServiceImpl.getAllProtectedMemoriesByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/get/shared-memories/{userId}")
    public ResponseEntity<List<ProtectedMemoryDto>> getAllSharedMemoriesWithAUserByUserId(@PathVariable("userId") String userId) {
        logger.info("[PublicMemory] GET Todos los Recuerdos Compartidos con un Usuario");
        return new ResponseEntity(this.protectedMemoryServiceImpl.getAllSharedMemoriesWithAUserByUserId(userId), HttpStatus.OK);
    }
}