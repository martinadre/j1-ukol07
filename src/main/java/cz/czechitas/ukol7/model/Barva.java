package cz.czechitas.ukol7.model;

public enum Barva {
    Bila("bílá"),
    Ruzova("růžová"),
    Fialova("fialová"),
    Vinova("vínová"),
    Zelena("zelená"),
    Modra("modrá"),
    ;

    private final String text;

    Barva(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
