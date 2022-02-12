package co.edu.practice.tse.dtos;

import co.edu.practice.tse.dtos.helpers.EnumVisibilityDto;
import co.edu.practice.tse.dtos.helpers.LocationDto;
import co.edu.practice.tse.dtos.helpers.MemoryPhotoDto;
import co.edu.practice.tse.dtos.helpers.VisualizationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PublicMemoryDto extends PrivateMemoryDto {
    private List<VisualizationDto> visualizationList;
    private int numViews;

    public PublicMemoryDto(Long id, String name, LocalDate memoryDate, LocalDate creationDate, EnumVisibilityDto visibility, List<String> tagList, UserDto creator, List<MemoryPhotoDto> memoryPhotoList, LocationDto location, List<VisualizationDto> visualizationList, int numViews) {
        super(id, name, memoryDate, creationDate, visibility, tagList, creator, memoryPhotoList, location);
        this.visualizationList = visualizationList;
        this.numViews = numViews;
    }
}
