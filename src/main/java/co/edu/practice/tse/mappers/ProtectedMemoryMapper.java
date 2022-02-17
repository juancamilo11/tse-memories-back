package co.edu.practice.tse.mappers;

import co.edu.practice.tse.collections.ProtectedMemory;
import co.edu.practice.tse.collections.helpers.Location;
import co.edu.practice.tse.collections.helpers.MemoryPhoto;
import co.edu.practice.tse.collections.helpers.Visualization;
import co.edu.practice.tse.dtos.ProtectedMemoryDto;
import co.edu.practice.tse.dtos.helpers.LocationDto;
import co.edu.practice.tse.dtos.helpers.MemoryPhotoDto;
import co.edu.practice.tse.dtos.helpers.VisualizationDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProtectedMemoryMapper {
    public ProtectedMemory fromDtoToEntity(ProtectedMemoryDto protectedMemoryDto) {
        return new ProtectedMemory(protectedMemoryDto.getId(),
                protectedMemoryDto.getName(),
                protectedMemoryDto.getMemoryDate(),
                protectedMemoryDto.getCreationDate(),
                protectedMemoryDto.getVisibility(),
                protectedMemoryDto.getTagList(),
                protectedMemoryDto.getCreatorId(),
                protectedMemoryDto.getMemoryPhotoList()
                        .stream()
                        .map(memoryPhotoDto -> MemoryPhoto.builder()
                                .urlPhoto(memoryPhotoDto.getUrlPhoto())
                                .description(memoryPhotoDto.getDescription())
                                .title(memoryPhotoDto.getTitle())
                                .build())
                        .collect(Collectors.toList()),
                Location.builder()
                        .city(protectedMemoryDto.getLocation().getCity())
                        .country(protectedMemoryDto.getLocation().getCountry())
                        .build(),
                protectedMemoryDto.getVisualizationList().stream()
                        .map(visualizationDto -> Visualization.builder()
                                .visualizationDate(visualizationDto.getVisualizationDate())
                                .userId(visualizationDto.getUserId()).build()).collect(Collectors.toList()),
                protectedMemoryDto.getAuthorizedEmailList());
    }

    public ProtectedMemoryDto fromEntityToDto(ProtectedMemory protectedMemory) {
        return new ProtectedMemoryDto(protectedMemory.getId(),
                protectedMemory.getName(),
                protectedMemory.getMemoryDate(),
                protectedMemory.getCreationDate(),
                protectedMemory.getVisibility(),
                protectedMemory.getTagList(),
                protectedMemory.getCreatorId(),
                protectedMemory.getMemoryPhotoList()
                        .stream()
                        .map(memoryPhoto -> MemoryPhotoDto.builder()
                                .urlPhoto(memoryPhoto.getUrlPhoto())
                                .description(memoryPhoto.getDescription())
                                .title(memoryPhoto.getTitle())
                                .build())
                        .collect(Collectors.toList()),
                LocationDto.builder()
                        .city(protectedMemory.getLocation().getCity())
                        .country(protectedMemory.getLocation().getCountry())
                        .build(),
                protectedMemory.getVisualizationList().stream()
                        .map(visualization -> VisualizationDto.builder()
                                .visualizationDate(visualization.getVisualizationDate())
                                .userId(visualization.getUserId()).build()).collect(Collectors.toList()),
                protectedMemory.getAuthorizedEmailList());
    }
}
