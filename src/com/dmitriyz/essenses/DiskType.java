package com.dmitriyz.essenses;

public enum DiskType {
    CommonDisk("Обычный диск"),
    Paraboloid("Параболлический диск");

    private String title;

    DiskType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "DiskType{" +
                "title='" + title + '\'' +
                '}';
    }
}