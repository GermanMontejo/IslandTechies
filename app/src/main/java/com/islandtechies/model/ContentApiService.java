package com.islandtechies.model;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.PUT;
import retrofit.http.Path;

public interface ContentApiService {

    @GET("/content/_design/news/_list/all/list")
    void loadContents(Callback<ListContentModels> callback);

    @PUT("/_users/org.couchdb.user:{user}")
    void signup(@Path("user") String username, @Body UserModel userModel, Callback<SignupResponseModel> callback);
}
