package co.edu.practice.tse.dtos.canonico;

import co.edu.practice.tse.dtos.PrivateMemoryDto;
import co.edu.practice.tse.dtos.ProtectedMemoryDto;
import co.edu.practice.tse.dtos.PublicMemoryDto;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@Builder(toBuilder = true)
public class AllUserMemoriesListDto {
    @NonNull
    private final List<PublicMemoryDto> publicMemories;
    @NonNull
    private final List<ProtectedMemoryDto> protectedMemories;
    @NonNull
    private final List<PrivateMemoryDto> privateMemories;

}