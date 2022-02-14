package co.edu.practice.tse.dtos;

import co.edu.practice.tse.dtos.helpers.EnumVisibilityDto;
import co.edu.practice.tse.dtos.helpers.LocationDto;
import co.edu.practice.tse.dtos.helpers.MemoryPhotoDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
public class PrivateMemoryDto {

    @NotBlank
    private String id;
    @NotBlank
    private String name;
    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate memoryDate;
    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate creationDate;
    @NotNull
    private String visibility;   //public, private, protected
    @NotEmpty
    private List<String> tagList;
    @NotBlank
    private String creatorId;
    @NotEmpty
    private List<MemoryPhotoDto> memoryPhotoList;
    @NotNull
    private LocationDto location;

    public PrivateMemoryDto(String id, String name, LocalDate memoryDate, LocalDate creationDate, String visibility, List<String> tagList, String creatorId, List<MemoryPhotoDto> memoryPhotoList, LocationDto location) {
        this.id = id;
        this.name = name;
        this.memoryDate = memoryDate;
        this.creationDate = creationDate;
        this.visibility = visibility;
        this.tagList = tagList;
        this.creatorId = creatorId;
        this.memoryPhotoList = memoryPhotoList;
        this.location = location;
        
        this.validateMemoryVisibility(visibility);
    }

    private void validateMemoryVisibility(String visibility) throws IllegalArgumentException {
        if(!EnumVisibilityDto.enumValueIsValid(visibility) && !visibility.equalsIgnoreCase("privado")) {
            throw new IllegalArgumentException("El tipo de visibilidad no es válida");
        }
    }
}
