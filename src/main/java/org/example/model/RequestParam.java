package org.example.model;

import com.google.gson.annotations.SerializedName;

public class RequestParam {
    @SerializedName("key")
    private String key;

    @SerializedName("value")
    private String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
