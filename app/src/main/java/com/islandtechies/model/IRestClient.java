package com.islandtechies.model;

public interface IRestClient {
    void loadContents();
    void login(UserModel userModel);
    void signup(UserModel userModel);
}
