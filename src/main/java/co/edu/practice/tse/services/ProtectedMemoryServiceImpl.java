package co.edu.practice.tse.services;

import co.edu.practice.tse.collections.ProtectedMemory;
import co.edu.practice.tse.collections.User;
import co.edu.practice.tse.collections.helpers.Visualization;
import co.edu.practice.tse.dtos.ProtectedMemoryDto;
import co.edu.practice.tse.dtos.helpers.VisualizationDto;
import co.edu.practice.tse.mappers.ProtectedMemoryMapper;
import co.edu.practice.tse.repositories.PrivateMemoryRepository;
import co.edu.practice.tse.repositories.ProtectedMemoryRepository;
import co.edu.practice.tse.repositories.PublicMemoryRepository;
import co.edu.practice.tse.repositories.UserRepository;
import co.edu.practice.tse.services.interfaces.ProtectedMemoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProtectedMemoryServiceImpl implements ProtectedMemoryService {
    private final PrivateMemoryRepository privateMemoryRepository;
    private final PublicMemoryRepository publicMemoryRepository;
    private final ProtectedMemoryRepository protectedMemoryRepository;
    private final ProtectedMemoryMapper protectedMemoryMapper;
    private final UserRepository userRepository;

    @Override
    public ProtectedMemoryDto saveOrUpdateNewProtectedMemory(ProtectedMemoryDto memoryDto) {
        if(this.publicMemoryRepository.existsById(memoryDto.getId())) {
            this.publicMemoryRepository.deleteById(memoryDto.getId());
        } else if(this.privateMemoryRepository.existsById(memoryDto.getId())) {
            this.privateMemoryRepository.deleteById(memoryDto.getId());
        }
        return this.saveProtectedMemory(memoryDto);
    }

    @Override
    public ProtectedMemoryDto saveProtectedMemory(ProtectedMemoryDto protectedMemoryDto) {
        return this.protectedMemoryMapper
                .fromEntityToDto(this.protectedMemoryRepository
                        .save(this.protectedMemoryMapper
                                .fromDtoToEntity(protectedMemoryDto)));
    }

    @Override
    public ResponseEntity<String> deleteProtectedMemoryById(String memoryId, String userId) {
        boolean memoryExists = this.protectedMemoryRepository
                .existsById(memoryId);
        if(!memoryExists) {
            return new ResponseEntity("El recuerdo solicitado para eliminación no existe", HttpStatus.NOT_FOUND);
        }
        ProtectedMemory protectedMemory = this.protectedMemoryRepository.findById(memoryId).get();
        if(!protectedMemory.getCreatorId().equals(userId)) {
            return new ResponseEntity("El usuario no es el dueño del recuerdo, por ende no puede eliminarlo", HttpStatus.UNAUTHORIZED);
        }
        this.protectedMemoryRepository.deleteById(memoryId);
        return new ResponseEntity("Recuerdo eliminado con éxito", HttpStatus.OK);
    }

    @Override
    public ProtectedMemoryDto saveOrUpdateMemory(ProtectedMemoryDto privateMemoryDto) {
        return null;
    }

    public List<ProtectedMemoryDto> getAllProtectedMemoriesByUserId(String userId) {
        return this.protectedMemoryRepository.findAllByCreatorId(userId)
                .stream()
                .map(this.protectedMemoryMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public String registerProtectedMemoryView(String memoryId, VisualizationDto visualizationDto) {
        Optional<ProtectedMemory> optionalProtectedMemory = this.protectedMemoryRepository.findById(memoryId);

        optionalProtectedMemory.ifPresent(protectedMemory -> {
            if(protectedMemory.getVisualizationList().stream().noneMatch(visualization -> visualization.getUserId().equals(visualizationDto.getUserId()))) {
                protectedMemory.getVisualizationList().add(Visualization.builder()
                        .visualizationDate(visualizationDto.getVisualizationDate())
                        .userId(visualizationDto.getUserId())
                        .build());
                this.protectedMemoryRepository.save(protectedMemory);
            }
        });
        return optionalProtectedMemory.isPresent() ? "+1 View" : "Memory not found";
    }

    @Override
    public List<ProtectedMemoryDto> getAllSharedMemoriesWithAUserByUserId(String userId) {
        Optional<User> userOptional = this.userRepository.findById(userId);

        return userOptional.map(user -> this.protectedMemoryRepository
                        .findAllByAuthorizedEmailList(user.getEmail())
                        .stream()
                        .map(this.protectedMemoryMapper::fromEntityToDto)
                        .collect(Collectors.toList()))
                .orElseThrow();
    }
}