package com.dmitriyz.essenses;

public enum Weather {
    HOT("жаркая"),
    WARM("теплая"),
    COLD("холодная"),
    FREEZING("ужасно холодная");
    private final String title;

    Weather(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "title='" + title + '\'' +
                '}';
    }
}
