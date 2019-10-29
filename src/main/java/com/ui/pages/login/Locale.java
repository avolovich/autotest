package com.ui.pages.login;

public enum Locale {
    ENGLISH("en"), GERMAN("de"), SPANISH("es"), FRENCH("fr"), ITALIAN("it"), JAPANESE("ja"), INVALID("hzhz");

    private String value;

    Locale(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
