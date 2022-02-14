package co.edu.practice.tse.dtos.helpers;

import lombok.*;

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
