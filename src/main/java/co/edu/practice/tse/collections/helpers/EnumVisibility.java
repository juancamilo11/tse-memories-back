package co.edu.practice.tse.collections.helpers;

public enum EnumVisibility {
    PUBLIC("publico"), PROTECTED("protegido"), PRIVATE("privado");
    private String visibility;

    EnumVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getVisibility() {
        return visibility;
    }
}
