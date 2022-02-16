package co.edu.practice.tse.dtos;

import co.edu.practice.tse.dtos.helpers.EnumVisibilityDto;
import co.edu.practice.tse.dtos.helpers.LocationDto;
import co.edu.practice.tse.dtos.helpers.MemoryPhotoDto;
import co.edu.practice.tse.dtos.helpers.VisualizationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PublicMemoryDto extends PrivateMemoryDto {
    @NotNull
    private List<VisualizationDto> visualizationList;

    public PublicMemoryDto(String id, String name, LocalDate memoryDate, LocalDate creationDate, String visibility, List<String> tagList, String creatorId, List<MemoryPhotoDto> memoryPhotoList, LocationDto location, List<VisualizationDto> visualizationList) {
        super(id, name, memoryDate, creationDate, visibility, tagList, creatorId, memoryPhotoList, location);
        this.visualizationList = visualizationList;
        this.validateMemoryVisibility(visibility);
    }

    private void validateMemoryVisibility(String visibility) throws IllegalArgumentException {
        if(!EnumVisibilityDto.enumValueIsValid(visibility)&& !visibility.equalsIgnoreCase("publico")) {
            throw new IllegalArgumentException("El tipo de visibilidad no es válida");
        }
    }
}
