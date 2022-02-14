package co.edu.practice.tse.mappers;

import co.edu.practice.tse.collections.PublicMemory;
import co.edu.practice.tse.collections.helpers.EnumVisibility;
import co.edu.practice.tse.collections.helpers.Location;
import co.edu.practice.tse.collections.helpers.MemoryPhoto;
import co.edu.practice.tse.collections.helpers.Visualization;
import co.edu.practice.tse.dtos.PublicMemoryDto;
import co.edu.practice.tse.dtos.helpers.EnumVisibilityDto;
import co.edu.practice.tse.dtos.helpers.LocationDto;
import co.edu.practice.tse.dtos.helpers.MemoryPhotoDto;
import co.edu.practice.tse.dtos.helpers.VisualizationDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
public class PublicMemoryMapper {
    public PublicMemory fromDtoToEntity(PublicMemoryDto publicMemoryDto) {
        return new PublicMemory(publicMemoryDto.getId(),
                publicMemoryDto.getName(),
                publicMemoryDto.getMemoryDate(),
                publicMemoryDto.getCreationDate(),
                publicMemoryDto.getVisibility(),
                publicMemoryDto.getTagList(),
                publicMemoryDto.getCreatorId(),
                publicMemoryDto.getMemoryPhotoList()
                        .stream()
                        .map(memoryPhotoDto -> MemoryPhoto.builder()
                                .urlPhoto(memoryPhotoDto.getUrlPhoto())
                                .description(memoryPhotoDto.getDescription())
                                .title(memoryPhotoDto.getTitle())
                                .build())
                        .collect(Collectors.toList()),
                Location.builder()
                        .city(publicMemoryDto.getLocation().getCity())
                        .country(publicMemoryDto.getLocation().getCountry())
                        .build(),
                publicMemoryDto.getVisualizationList().stream()
                        .map(visualizationDto -> Visualization.builder()
                                .visualizationDate(visualizationDto.getVisualizationDate())
                                .userId(visualizationDto.getUserId()).build()).collect(Collectors.toList()),
                publicMemoryDto.getNumViews());
    }

    public PublicMemoryDto fromEntityToDto(PublicMemory publicMemory) {
        return new PublicMemoryDto(publicMemory.getId(),
                publicMemory.getName(),
                publicMemory.getMemoryDate(),
                publicMemory.getCreationDate(),
                publicMemory.getVisibility(),
                publicMemory.getTagList(),
                publicMemory.getCreatorId(),
                publicMemory.getMemoryPhotoList()
                        .stream()
                        .map(memoryPhoto -> MemoryPhotoDto.builder()
                                .urlPhoto(memoryPhoto.getUrlPhoto())
                                .description(memoryPhoto.getDescription())
                                .title(memoryPhoto.getTitle())
                                .build())
                        .collect(Collectors.toList()),
                LocationDto.builder()
                        .city(publicMemory.getLocation().getCity())
                        .country(publicMemory.getLocation().getCountry())
                        .build(),
                publicMemory.getVisualizationList().stream()
                        .map(visualization -> VisualizationDto.builder()
                                .visualizationDate(visualization.getVisualizationDate())
                                .userId(visualization.getUserId()).build()).collect(Collectors.toList()),
                publicMemory.getNumViews());
    }

}