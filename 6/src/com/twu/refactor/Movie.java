package com.twu.refactor;

public class Movie {
    private String title;
    private MovieTypeEnum typeEnum;

    public Movie(String title, MovieTypeEnum typeEnum) {
        this.title = title;
        this.typeEnum = typeEnum;
    }

    public MovieTypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(MovieTypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    public String getTitle() {
        return title;
    }
}

