package com.dmitriyz.essenses;

import java.lang.Object;

public enum Position {
    WATER("Water"),
    GROUND("Ground"),
    AIR("Air");

    private String title;

    Position(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Position{" +
                "title='" + title + '\'' +
                '}';
    }
}
