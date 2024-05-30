package org.example.model;

import com.google.gson.annotations.SerializedName;



public class ApiError {
    @SerializedName("error")
    private Error error;

    public Error getError() {
        return error;
    }
}

