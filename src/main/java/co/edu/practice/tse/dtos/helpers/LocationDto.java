package co.edu.practice.tse.dtos.helpers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class LocationDto {
    @NotBlank
    private String country;
    @NotBlank
    private String city;
}
