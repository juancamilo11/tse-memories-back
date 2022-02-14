package co.edu.practice.tse.dtos.helpers;

import java.util.Arrays;
import java.util.Locale;

public enum EnumVisibilityDto {
    PUBLIC("publico"), PROTECTED("protegido"), PRIVATE("privado");
    private String visibility;

    EnumVisibilityDto(String visibility) {
        this.visibility = visibility;
    }

    public String getVisibility() {
        return visibility;
    }

    public static boolean enumValueIsValid(String visibility) {
        return Arrays
                .stream(EnumVisibilityDto.values())
                .anyMatch(enumValue -> enumValue.getVisibility().equals(visibility.toLowerCase()));
    }
}
