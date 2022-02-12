package co.edu.practice.tse.collections;

import co.edu.practice.tse.collections.helpers.EnumVisibility;
import co.edu.practice.tse.collections.helpers.Location;
import co.edu.practice.tse.collections.helpers.MemoryPhoto;
import co.edu.practice.tse.collections.helpers.Visualization;
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
public class ProtectedMemory extends PublicMemory{
    private List<String> authorizedIdList;

    @Builder
    public ProtectedMemory(Long id, String name, LocalDate memoryDate, LocalDate creationDate, EnumVisibility visibility, List<String> tagList, User creator, List<MemoryPhoto> memoryPhotoList, Location location, List<Visualization> visualizationList, int numViews, List<String> authorizedIdList) {
        super(id, name, memoryDate, creationDate, visibility, tagList, creator, memoryPhotoList, location, visualizationList, numViews);
        this.authorizedIdList = authorizedIdList;
    }
}
