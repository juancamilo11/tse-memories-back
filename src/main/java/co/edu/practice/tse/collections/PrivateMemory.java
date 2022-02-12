package co.edu.practice.tse.collections;

import co.edu.practice.tse.collections.helpers.EnumVisibility;
import co.edu.practice.tse.collections.helpers.Location;
import co.edu.practice.tse.collections.helpers.MemoryPhoto;
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
public class PrivateMemory {
    @Id
    private String id;
    private String name;
    private LocalDate memoryDate;
    private LocalDate creationDate;
    private EnumVisibility visibility;
    private List<String> tagList;
    private String creatorId;
    private List<MemoryPhoto> memoryPhotoList;
    private Location location;
}
