package co.edu.practice.tse.services.interfaces;

import co.edu.practice.tse.dtos.PrivateMemoryDto;
import org.springframework.http.ResponseEntity;

public interface PrivateMemoryService {

    PrivateMemoryDto saveNewPrivateMemory(PrivateMemoryDto privateMemoryDto);
    ResponseEntity<String>  deletePrivateMemoryById(String memoryId, String userId);

}
