package co.edu.practice.tse.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class UserDto {
    @NotBlank
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String urlProfilePhoto;
}
