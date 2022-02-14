package co.edu.practice.tse.services;

import co.edu.practice.tse.dtos.PublicMemoryDto;
import co.edu.practice.tse.mappers.PublicMemoryMapper;
import co.edu.practice.tse.repositories.PublicMemoryRepository;
import org.springframework.stereotype.Service;

@Service
public class PublicMemoryService {
    private final PublicMemoryRepository publicMemoryRepository;
    private final PublicMemoryMapper publicMemoryMapper;

    public PublicMemoryService(PublicMemoryRepository publicMemoryRepository, PublicMemoryMapper publicMemoryMapper) {
        this.publicMemoryRepository = publicMemoryRepository;
        this.publicMemoryMapper = publicMemoryMapper;
    }

    public PublicMemoryDto saveNewPublicMemory(PublicMemoryDto publicMemoryDto) {
        return this.publicMemoryMapper
                .fromEntityToDto(this.publicMemoryRepository
                        .save(this.publicMemoryMapper
                                .fromDtoToEntity(publicMemoryDto)));
    }
}
