package co.edu.practice.tse.collections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class ProtectedMemory extends PublicMemory{
    private List<String> authorizedIdList;
}
