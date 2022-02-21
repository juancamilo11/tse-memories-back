package co.edu.practice.tse.services.interfaces;

import co.edu.practice.tse.dtos.PrivateMemoryDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PrivateMemoryService {
    PrivateMemoryDto saveOrUpdateNewPrivateMemory(PrivateMemoryDto privateMemoryDto);
    ResponseEntity<String>  deletePrivateMemoryById(String memoryId, String userId);
    PrivateMemoryDto savePrivateMemory(PrivateMemoryDto privateMemoryDto);
    List<PrivateMemoryDto> getAllPrivateMemoriesByUserId(String userId);
}