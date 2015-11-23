package com.islandtechies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContentModel {

    @Expose
    @SerializedName("id")
    private String Id;

    @Expose
    @SerializedName("content")
    private String content;

    @Expose
    @SerializedName("date")
    private String date;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("type")
    private String type;

    @Expose
    @SerializedName("news_id")
    private String newsId;

    @Expose
    @SerializedName("author_id")
    private String authorId;

    @Expose
    @SerializedName("image_url")
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
