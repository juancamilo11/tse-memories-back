package co.edu.practice.tse.mappers;

import co.edu.practice.tse.collections.PrivateMemory;
import co.edu.practice.tse.dtos.PrivateMemoryDto;
import org.springframework.stereotype.Component;

@Component
public class PrivateMemoryMapper {
    public PrivateMemory fromDtoToEntity(PrivateMemoryDto privateMemoryDto){
        return new PrivateMemory(privateMemoryDto.getId(),
                privateMemoryDto.getName(),
                privateMemoryDto.getMemoryDate(),
                privateMemoryDto.getCreationDate(),
                privateMemoryDto.getVisibility(),
                privateMemoryDto.getTagList(),
                privateMemoryDto.
    }
}
