package co.edu.practice.tse.services;

import co.edu.practice.tse.dtos.ProtectedMemoryDto;
import co.edu.practice.tse.mappers.ProtectedMemoryMapper;
import co.edu.practice.tse.repositories.ProtectedMemoryRepository;
import org.springframework.stereotype.Service;

@Service
public class ProtectedMemoryService {
    private final ProtectedMemoryRepository protectedMemoryRepository;
    private final ProtectedMemoryMapper protectedMemoryMapper;

    public ProtectedMemoryService(ProtectedMemoryRepository protectedMemoryRepository, ProtectedMemoryMapper protectedMemoryMapper) {
        this.protectedMemoryRepository = protectedMemoryRepository;
        this.protectedMemoryMapper = protectedMemoryMapper;
    }

    public ProtectedMemoryDto saveNewProtectedMemory(ProtectedMemoryDto protectedMemoryDto) {
        return this.protectedMemoryMapper
                .fromEntityToDto(this.protectedMemoryRepository
                        .save(this.protectedMemoryMapper
                                .fromDtoToEntity(protectedMemoryDto)));
    }
    }

