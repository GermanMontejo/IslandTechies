package com.islandtechies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignupResponseModel {
    @Expose
    @SerializedName("ok")
    boolean successful;

    @Expose
    @SerializedName("id")
    String id;

    @Expose
    @SerializedName("error")
    String error;

    @Expose
    @SerializedName("reason")
    String reason;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
