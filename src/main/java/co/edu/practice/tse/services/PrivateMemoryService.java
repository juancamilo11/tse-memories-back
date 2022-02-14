package co.edu.practice.tse.services;

import co.edu.practice.tse.dtos.PrivateMemoryDto;
import co.edu.practice.tse.mappers.PrivateMemoryMapper;
import co.edu.practice.tse.repositories.PrivateMemoryRepository;
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
}
