package com.dmitriyz.essenses;

public enum Circs {
    WEALTHY("богатый"),
    POOR("бедный");
    private final String title;

    Circs(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}
