package org.example.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Error {
    @SerializedName("error_code")
    private int errorCode;

    @SerializedName("error_msg")
    private String errorMessage;

    @SerializedName("request_params")
    private List<RequestParam> requestParams;

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public List<RequestParam> getRequestParams() {
        return requestParams;
    }
}
