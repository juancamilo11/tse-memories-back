package co.edu.practice.tse.services;

import co.edu.practice.tse.collections.ProtectedMemory;
import co.edu.practice.tse.collections.PublicMemory;
import co.edu.practice.tse.collections.User;
import co.edu.practice.tse.collections.helpers.Visualization;
import co.edu.practice.tse.dtos.PublicMemoryDto;
import co.edu.practice.tse.dtos.helpers.VisualizationDto;
import co.edu.practice.tse.mappers.PublicMemoryMapper;
import co.edu.practice.tse.repositories.PrivateMemoryRepository;
import co.edu.practice.tse.repositories.ProtectedMemoryRepository;
import co.edu.practice.tse.repositories.PublicMemoryRepository;
import co.edu.practice.tse.repositories.UserRepository;
import co.edu.practice.tse.services.interfaces.PublicMemoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PublicMemoryServiceImpl implements PublicMemoryService {
    private final PrivateMemoryRepository privateMemoryRepository;
    private final PublicMemoryRepository publicMemoryRepository;
    private final ProtectedMemoryRepository protectedMemoryRepository;
    private final PublicMemoryMapper publicMemoryMapper;
    private final UserRepository userRepository;

    @Override
    public PublicMemoryDto saveOrUpdateNewPublicMemory(PublicMemoryDto memoryDto) {
        if (this.privateMemoryRepository.existsById(memoryDto.getId())) {
            this.privateMemoryRepository.deleteById(memoryDto.getId());
        } else if (this.protectedMemoryRepository.existsById(memoryDto.getId())) {
            this.protectedMemoryRepository.deleteById(memoryDto.getId());
        }
        return this.savePublicMemory(memoryDto);
    }

    @Override
    public PublicMemoryDto savePublicMemory(PublicMemoryDto publicMemoryDto) {
        return this.publicMemoryMapper
                .fromEntityToDto(this.publicMemoryRepository
                        .save(this.publicMemoryMapper
                                .fromDtoToEntity(publicMemoryDto)));
    }

    @Override
    public List<PublicMemoryDto> getAllPublicMemoriesByNameOrTagName(String nameOrTagName) {
        return Stream.concat(this.publicMemoryRepository.findAllByName(nameOrTagName)
                .stream()
                .map(this.publicMemoryMapper::fromEntityToDto),
                this.publicMemoryRepository.findAllByTagList(nameOrTagName)
                        .stream()
                        .map(this.publicMemoryMapper::fromEntityToDto))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<String> deletePublicMemoryById(String memoryId, String userId) {
        boolean memoryExists = this.publicMemoryRepository
                .existsById(memoryId);
        if(!memoryExists) {
            return new ResponseEntity("El recuerdo solicitado para eliminación no existe", HttpStatus.NOT_FOUND);
        }
        PublicMemory publicMemory = this.publicMemoryRepository.findById(memoryId).get();
        if(!publicMemory.getCreatorId().equals(userId)) {
            return new ResponseEntity("El usuario no es el dueño del recuerdo, por ende no puede eliminarlo", HttpStatus.UNAUTHORIZED);
        }
        this.publicMemoryRepository.deleteById(memoryId);
        return new ResponseEntity("Recuerdo eliminado con éxito", HttpStatus.OK);
    }

    @Override
    public PublicMemoryDto registerPublicMemoryView(String memoryId, VisualizationDto visualizationDto) {
        Optional<PublicMemory> optionalPublicMemory = this.publicMemoryRepository.findById(memoryId);

        optionalPublicMemory.ifPresent(publicMemory -> {
            if (publicMemory.getVisualizationList().stream().noneMatch(visualization -> visualization.getUserId().equals(visualizationDto.getUserId()))) {
                publicMemory.getVisualizationList().add(Visualization.builder()
                        .visualizationDate(visualizationDto.getVisualizationDate())
                        .userId(visualizationDto.getUserId())
                        .build());
                this.publicMemoryRepository.save(publicMemory);
            }
        });

        return this.publicMemoryMapper.fromEntityToDto(optionalPublicMemory.orElseThrow());
    }

    @Override
    public PublicMemoryDto getMemoryByMemoryId(String memoryId) {
        return this.publicMemoryMapper.fromEntityToDto(this.publicMemoryRepository.findById(memoryId).orElse(new PublicMemory()));
    }

    @Override
    public List<PublicMemoryDto> getAllMemoriesByOwnerEmail(String email) {
        Optional<User> userOptional = this.userRepository.findByEmail(email);
        return userOptional.map(user -> this.publicMemoryRepository.
                findAllByCreatorId(user.getId())
                .stream()
                .map(this.publicMemoryMapper::fromEntityToDto)
                .collect(Collectors.toList())).orElse(Collections.emptyList());
    }

    @Override
    public List<PublicMemoryDto> getAllPublicMemoriesByUserId(String userId) {
        return this.publicMemoryRepository.findAllByCreatorId(userId)
                .stream()
                .map(this.publicMemoryMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }
}