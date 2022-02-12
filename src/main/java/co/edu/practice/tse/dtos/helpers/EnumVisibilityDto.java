package co.edu.practice.tse.dtos.helpers;

public enum EnumVisibilityDto {
    PUBLIC("publico"), PROTECTED("protegido"), PRIVATE("privado");
    private String visibility;

    EnumVisibilityDto(String visibility) {
        this.visibility = visibility;
    }

    public String getVisibility() {
        return visibility;
    }
}
