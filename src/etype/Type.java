package eType;

public enum Type {
    WORK("Рабочая"),
    PERSONAL("Персональная");
    String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
