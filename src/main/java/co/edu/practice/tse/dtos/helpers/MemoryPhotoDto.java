package co.edu.practice.tse.dtos.helpers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class MemoryPhotoDto {
    @NotBlank
    private String urlPhoto;
    @NotBlank
    private String title;
    @NotNull
    private String description;

}
