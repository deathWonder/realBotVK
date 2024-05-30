package org.example.initialization;

import org.example.handler.ApiHelper;
import org.example.model.InitAttributes;
import org.example.utils.RequestBuilder;

import java.net.HttpURLConnection;

public class Initialization {
    private final RequestBuilder requestBuilder = new RequestBuilder();

    public InitAttributes getPermission() {
        String url = requestBuilder.createInitRequest();
        InitAttributes attribute;
        HttpURLConnection connection = ApiHelper.connectionSetup(url);
        attribute = ApiHelper.readAttribute(connection);
        return attribute;
    }


}
