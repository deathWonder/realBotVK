package org.example.model;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {
    @SerializedName("response")
    private int response;

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }
}
