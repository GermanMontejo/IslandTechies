package com.islandtechies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserModel {

    @Expose
    @SerializedName ("name")
    String username;

    @Expose
    @SerializedName("password")
    String password;

    @Expose
    @SerializedName("roles")
    List<String> roles;

    @Expose
    @SerializedName("type")
    String type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
