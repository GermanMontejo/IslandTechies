package com.islandtechies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListContentModels {
    public List<ContentModel> getContentModelList() {
        return contentModelList;
    }

    @Expose
    @SerializedName("news")
    List<ContentModel> contentModelList;
}
