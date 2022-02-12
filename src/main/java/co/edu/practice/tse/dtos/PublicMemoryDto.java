package co.edu.practice.tse.dtos;

import co.edu.practice.tse.dtos.helpers.EnumVisibilityDto;
import co.edu.practice.tse.dtos.helpers.LocationDto;
import co.edu.practice.tse.dtos.helpers.MemoryPhotoDto;
import co.edu.practice.tse.dtos.helpers.VisualizationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PublicMemoryDto extends PrivateMemoryDto {
    private List<VisualizationDto> visualizationList;
    private int numViews;

    public PublicMemoryDto(String id, String name, LocalDate memoryDate, LocalDate creationDate, EnumVisibilityDto visibility, List<String> tagList, String creatorId, List<MemoryPhotoDto> memoryPhotoList, LocationDto location, List<VisualizationDto> visualizationList, int numViews) {
        super(id, name, memoryDate, creationDate, visibility, tagList, creatorId, memoryPhotoList, location);
        this.visualizationList = visualizationList;
        this.numViews = numViews;
    }
}
