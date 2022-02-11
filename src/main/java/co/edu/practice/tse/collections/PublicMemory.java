package co.edu.practice.tse.collections;

import co.edu.practice.tse.collections.helpers.Visualization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data

public class PublicMemory extends PrivateMemory {
    private List<Visualization> visualizationList;
    private int numViews;
}
