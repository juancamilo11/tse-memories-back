package co.edu.practice.tse.services;

import co.edu.practice.tse.collections.PrivateMemory;
import co.edu.practice.tse.dtos.PrivateMemoryDto;
import co.edu.practice.tse.mappers.PrivateMemoryMapper;
import co.edu.practice.tse.repositories.PrivateMemoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PrivateMemoryService {
    private final PrivateMemoryRepository privateMemoryRepository;
    private final PrivateMemoryMapper privateMemoryMapper;

    public PrivateMemoryService(PrivateMemoryRepository privateMemoryRepository, PrivateMemoryMapper privateMemoryMapper) {
        this.privateMemoryRepository = privateMemoryRepository;
        this.privateMemoryMapper = privateMemoryMapper;
    }

    public PrivateMemoryDto saveNewPrivateMemory(PrivateMemoryDto privateMemoryDto) {
        return this.privateMemoryMapper
                .fromEntityToDto(this.privateMemoryRepository
                        .save(this.privateMemoryMapper
                                .fromDtoToEntity(privateMemoryDto)));
    }

    public ResponseEntity<String> deletePrivateMemoryById(String memoryId, String userId) {
        boolean memoryExists = this.privateMemoryRepository
                .existsById(memoryId);
        if(!memoryExists) {
            return new ResponseEntity("El recuerdo solicitado para eliminación no existe", HttpStatus.NOT_FOUND);
        }
        PrivateMemory privateMemory = this.privateMemoryRepository.findById(memoryId).get();
        if(!privateMemory.getCreatorId().equals(userId)) {
            return new ResponseEntity("El usuario no es el dueño del recuerdo, por ende no puede eliminarlo", HttpStatus.UNAUTHORIZED);
        }
        this.privateMemoryRepository.deleteById(memoryId);
        return new ResponseEntity("Recuerdo eliminado con éxito", HttpStatus.OK);
    }
}
