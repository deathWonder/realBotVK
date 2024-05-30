package org.example.model;

import com.google.gson.annotations.SerializedName;

public class InitAttributes {
    private InitResponse response;
    public String getKey(){
        return response.key;
    }
    public String getServer(){
        return response.server;
    }
    public String getTs(){
        return response.ts;
    }
    public void setTs(String ts) {
        response.ts = ts;
    }

    public static class InitResponse {
        @SerializedName("key")
        private String key;

        @SerializedName("server")
        private String server;

        @SerializedName("ts")
        private String ts;
    }
}

