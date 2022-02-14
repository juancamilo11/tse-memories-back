package co.edu.practice.tse.dtos;

import co.edu.practice.tse.dtos.helpers.EnumVisibilityDto;
import co.edu.practice.tse.dtos.helpers.LocationDto;
import co.edu.practice.tse.dtos.helpers.MemoryPhotoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
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
    private EnumVisibilityDto visibility;
    @NotEmpty
    private List<String> tagList;
    @NotBlank
    private String creatorId;
    @NotEmpty
    private List<MemoryPhotoDto> memoryPhotoList;
    @NotNull
    private LocationDto location;
}
