package co.edu.practice.tse.services.interfaces;

import co.edu.practice.tse.dtos.PublicMemoryDto;
import co.edu.practice.tse.dtos.helpers.VisualizationDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PublicMemoryService {
    PublicMemoryDto saveOrUpdateNewPublicMemory(PublicMemoryDto publicMemoryDto);
    ResponseEntity<String> deletePublicMemoryById(String memoryId, String userId);
    String registerPublicMemoryView(String memoryId, VisualizationDto visualizationDto);
    PublicMemoryDto getMemoryByMemoryId(String memoryId);
    List<PublicMemoryDto> getAllMemoriesByOwnerEmail(String email);
    List<PublicMemoryDto> getAllPublicMemoriesByUserId(String userId);
    PublicMemoryDto savePublicMemory(PublicMemoryDto publicMemoryDto);
    List<PublicMemoryDto> getAllPublicMemoriesByNameOrTagName(String nameOrTagName);
}