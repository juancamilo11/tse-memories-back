package co.edu.practice.tse.dtos;

import co.edu.practice.tse.dtos.helpers.EnumVisibilityDto;
import co.edu.practice.tse.dtos.helpers.LocationDto;
import co.edu.practice.tse.dtos.helpers.MemoryPhotoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrivateMemoryDto {
    @Id
    private Long id;
    private String name;
    private LocalDate memoryDate;
    private LocalDate creationDate;
    private EnumVisibilityDto visibility;
    private List<String> tagList;
    private UserDto creator;
    private List<MemoryPhotoDto> memoryPhotoList;
    private LocationDto location;
}
