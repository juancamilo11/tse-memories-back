package co.edu.practice.tse.services.interfaces;

import co.edu.practice.tse.dtos.ProtectedMemoryDto;
import co.edu.practice.tse.dtos.helpers.VisualizationDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProtectedMemoryService {

    ProtectedMemoryDto saveOrUpdateNewProtectedMemory(ProtectedMemoryDto privateMemoryDto);
    ResponseEntity<String> deleteProtectedMemoryById(String memoryId, String userId);
    ProtectedMemoryDto saveOrUpdateMemory(ProtectedMemoryDto privateMemoryDto);
    ProtectedMemoryDto registerProtectedMemoryView(String memoryId, VisualizationDto visualizationDto);
    ProtectedMemoryDto saveProtectedMemory(ProtectedMemoryDto protectedMemoryDto);
    List<ProtectedMemoryDto> getAllSharedMemoriesWithAUserByUserId(String userId);
}