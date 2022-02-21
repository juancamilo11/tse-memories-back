package co.edu.practice.tse.services;

import co.edu.practice.tse.dtos.PrivateMemoryDto;
import co.edu.practice.tse.dtos.canonico.AllUserMemoriesListDto;
import co.edu.practice.tse.repositories.PrivateMemoryRepository;
import co.edu.practice.tse.repositories.ProtectedMemoryRepository;
import co.edu.practice.tse.repositories.PublicMemoryRepository;
import co.edu.practice.tse.services.interfaces.GeneralMemoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class GeneralMemoryServiceImpl implements GeneralMemoryService {

    private final PrivateMemoryRepository privateMemoryRepository;
    private final PublicMemoryRepository publicMemoryRepository;
    private final ProtectedMemoryRepository protectedMemoryRepository;
    private final PrivateMemoryServiceImpl privateMemoryService;
    private final PublicMemoryServiceImpl publicMemoryService;
    private final ProtectedMemoryServiceImpl protectedMemoryService;

    @Override
    public boolean verifyPublicExistenceMemoryWithTheSameId(String memoryId) {
        return this.publicMemoryRepository.existsById(memoryId);
    }

    @Override
    public boolean verifyProtectedExistenceMemoryWithTheSameId(String memoryId) {
        return this.protectedMemoryRepository.existsById(memoryId);
    }

    @Override
    public boolean verifyPrivateExistenceMemoryWithTheSameId(String memoryId) {
        return this.privateMemoryRepository.existsById(memoryId);
    }

    @Override
    public void deleteMemoryFromPublicCollection(PrivateMemoryDto privateMemoryDto) {
        this.publicMemoryRepository.deleteById(privateMemoryDto.getId());
    }

    @Override
    public void deleteMemoryFromProtectedCollection(PrivateMemoryDto privateMemoryDto) {
        this.protectedMemoryRepository.deleteById(privateMemoryDto.getId());
    }

    @Override
    public AllUserMemoriesListDto getAllUserMemories(String userId) {
         return AllUserMemoriesListDto.builder()
                .publicMemories(this.publicMemoryService.getAllPublicMemoriesByUserId(userId))
                .protectedMemories(this.protectedMemoryService.getAllProtectedMemoriesByUserId(userId))
                .privateMemories(this.privateMemoryService.getAllPrivateMemoriesByUserId(userId))
                .build();
    }

}