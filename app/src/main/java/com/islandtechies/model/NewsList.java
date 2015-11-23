package com.islandtechies.model;

public class NewsList {
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    private String title;
    private String content;
    private String imageUrl;

    public NewsList(String imageUrl, String title, String content) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
    }
}
