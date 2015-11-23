package com.islandtechies.model;

import retrofit.Callback;
import retrofit.http.GET;

public interface ContentApiService {

    @GET("/content/_design/news/_list/all/list")
    void loadContents(Callback<ListContentModels> callback);
}
