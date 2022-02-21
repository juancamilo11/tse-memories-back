package co.edu.practice.tse.services;

import co.edu.practice.tse.collections.PrivateMemory;
import co.edu.practice.tse.dtos.PrivateMemoryDto;
import co.edu.practice.tse.mappers.PrivateMemoryMapper;
import co.edu.practice.tse.repositories.PrivateMemoryRepository;
import co.edu.practice.tse.repositories.ProtectedMemoryRepository;
import co.edu.practice.tse.repositories.PublicMemoryRepository;
import co.edu.practice.tse.services.interfaces.PrivateMemoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PrivateMemoryServiceImpl implements PrivateMemoryService {

    private final PrivateMemoryRepository privateMemoryRepository;
    private final PublicMemoryRepository publicMemoryRepository;
    private final ProtectedMemoryRepository protectedMemoryRepository;
    private final PrivateMemoryMapper privateMemoryMapper;

    public PrivateMemoryDto saveOrUpdateNewPrivateMemory(PrivateMemoryDto memoryDto) {
        System.out.println(memoryDto);
        if(this.publicMemoryRepository.existsById(memoryDto.getId())) {
            this.publicMemoryRepository.deleteById(memoryDto.getId());
        } else if(this.protectedMemoryRepository.existsById(memoryDto.getId())) {
            this.protectedMemoryRepository.deleteById(memoryDto.getId());
        }
        return this.savePrivateMemory(memoryDto);
    }

    public PrivateMemoryDto savePrivateMemory(PrivateMemoryDto privateMemoryDto) {
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

    public List<PrivateMemoryDto> getAllPrivateMemoriesByUserId(String userId) {
        return this.privateMemoryRepository.findAllByCreatorId(userId)
                .stream()
                .map(this.privateMemoryMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }

}