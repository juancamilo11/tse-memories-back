package co.edu.practice.tse.mappers;

import co.edu.practice.tse.collections.PrivateMemory;
import co.edu.practice.tse.collections.helpers.EnumVisibility;
import co.edu.practice.tse.collections.helpers.Location;
import co.edu.practice.tse.collections.helpers.MemoryPhoto;
import co.edu.practice.tse.dtos.PrivateMemoryDto;
import co.edu.practice.tse.dtos.helpers.EnumVisibilityDto;
import co.edu.practice.tse.dtos.helpers.LocationDto;
import co.edu.practice.tse.dtos.helpers.MemoryPhotoDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PrivateMemoryMapper {
    public PrivateMemory fromDtoToEntity(PrivateMemoryDto privateMemoryDto){
        return new PrivateMemory(privateMemoryDto.getId(),
                privateMemoryDto.getName(),
                privateMemoryDto.getMemoryDate(),
                privateMemoryDto.getCreationDate(),
                privateMemoryDto.getVisibility(),
                privateMemoryDto.getTagList(),
                privateMemoryDto.getCreatorId(),
                privateMemoryDto.getMemoryPhotoList()
                        .stream()
                        .map(memoryPhotoDto -> MemoryPhoto.builder()
                                .urlPhoto(memoryPhotoDto.getUrlPhoto())
                                .description(memoryPhotoDto.getDescription())
                                .title(memoryPhotoDto.getTitle())
                                .build())
                        .collect(Collectors.toList()),
                Location.builder()
                        .city(privateMemoryDto.getLocation().getCity())
                        .country(privateMemoryDto.getLocation().getCountry())
                        .build());
    }

    public PrivateMemoryDto fromEntityToDto(PrivateMemory privateMemory){
        return new PrivateMemoryDto(privateMemory.getId(),
                privateMemory.getName(),
                privateMemory.getMemoryDate(),
                privateMemory.getCreationDate(),
                privateMemory.getVisibility(),
                privateMemory.getTagList(),
                privateMemory.getCreatorId(),
                privateMemory.getMemoryPhotoList()
                        .stream()
                        .map(memoryPhoto -> MemoryPhotoDto.builder()
                                .urlPhoto(memoryPhoto.getUrlPhoto())
                                .description(memoryPhoto.getDescription())
                                .title(memoryPhoto.getTitle())
                                .build())
                        .collect(Collectors.toList()),
                LocationDto.builder()
                        .city(privateMemory.getLocation().getCity())
                        .country(privateMemory.getLocation().getCountry())
                        .build());
    }
}
