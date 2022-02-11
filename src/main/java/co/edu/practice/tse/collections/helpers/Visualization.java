package co.edu.practice.tse.collections.helpers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Visualization {
    private String userId;
    private LocalDate visualizationDate;
}
