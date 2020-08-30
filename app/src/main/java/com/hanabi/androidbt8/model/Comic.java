package com.hanabi.androidbt8.model;

import java.util.Date;

public class Comic {

    private int idComic;
    private int image;
    private String name;
    private String newChapter;
    private String author;
    private Date updateTime;
    private String content;

    public Comic(int idComic, int image, String name, String newChapter, String author, Date updateTime, String content) {
        this.idComic = idComic;
        this.image = image;
        this.name = name;
        this.newChapter = newChapter;
        this.author = author;
        this.updateTime = updateTime;
        this.content = content;
    }

    public int getIdComic() {
        return idComic;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getNewChapter() {
        return newChapter;
    }

    public String getAuthor() {
        return author;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public String getContent() {
        return content;
    }
}
