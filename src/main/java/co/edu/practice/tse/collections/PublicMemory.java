package co.edu.practice.tse.collections;

import co.edu.practice.tse.collections.helpers.EnumVisibility;
import co.edu.practice.tse.collections.helpers.Location;
import co.edu.practice.tse.collections.helpers.MemoryPhoto;
import co.edu.practice.tse.collections.helpers.Visualization;
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
public class PublicMemory extends PrivateMemory {
    private List<Visualization> visualizationList;
    private int numViews;

    public PublicMemory(String id, String name, LocalDate memoryDate, LocalDate creationDate, EnumVisibility visibility, List<String> tagList, String creatorId, List<MemoryPhoto> memoryPhotoList, Location location, List<Visualization> visualizationList, int numViews) {
        super(id, name, memoryDate, creationDate, visibility, tagList, creatorId, memoryPhotoList, location);
        this.visualizationList = visualizationList;
        this.numViews = numViews;
    }
}
