package co.edu.practice.tse.dtos;

import co.edu.practice.tse.dtos.helpers.EnumVisibilityDto;
import co.edu.practice.tse.dtos.helpers.LocationDto;
import co.edu.practice.tse.dtos.helpers.MemoryPhotoDto;
import co.edu.practice.tse.dtos.helpers.VisualizationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProtectedMemoryDto extends PublicMemoryDto {
    private List<String> authorizedIdList;

    @Builder
    public ProtectedMemoryDto(Long id, String name, LocalDate memoryDate, LocalDate creationDate, EnumVisibilityDto visibility, List<String> tagList, UserDto creator, List<MemoryPhotoDto> memoryPhotoList, LocationDto location, List<VisualizationDto> visualizationList, int numViews, List<String> authorizedIdList) {
        super(id, name, memoryDate, creationDate, visibility, tagList, creator, memoryPhotoList, location, visualizationList, numViews);
        this.authorizedIdList = authorizedIdList;
    }
}
