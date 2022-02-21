package co.edu.practice.tse.services.interfaces;

import co.edu.practice.tse.dtos.PrivateMemoryDto;
import co.edu.practice.tse.dtos.canonico.AllUserMemoriesListDto;

public interface GeneralMemoryService {
    boolean verifyPublicExistenceMemoryWithTheSameId(String memoryId);
    boolean verifyProtectedExistenceMemoryWithTheSameId(String memoryId);
    boolean verifyPrivateExistenceMemoryWithTheSameId(String memoryId);
    void deleteMemoryFromPublicCollection(PrivateMemoryDto privateMemoryDto);
    void deleteMemoryFromProtectedCollection(PrivateMemoryDto privateMemoryDto);
    AllUserMemoriesListDto getAllUserMemories(String userId);
}