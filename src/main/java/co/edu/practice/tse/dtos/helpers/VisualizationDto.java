package co.edu.practice.tse.dtos.helpers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class VisualizationDto {
    @NotBlank
    private String userId;
    @DateTimeFormat(style="yyyy-MM-dd")
    private LocalDate visualizationDate;
}
