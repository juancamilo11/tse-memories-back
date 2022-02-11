package co.edu.practice.tse.collections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Usuario {
    @Id

    private String id;
    private String name;
    private String email;
    private String urlProfilePhoto;
}
