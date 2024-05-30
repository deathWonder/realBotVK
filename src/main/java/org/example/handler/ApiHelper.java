package org.example.handler;

import com.google.gson.Gson;
import org.example.model.Event;
import org.example.model.InitAttributes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiHelper {

    private static final Gson gson = new Gson();

    public static InitAttributes readAttribute(HttpURLConnection connection) {
        String response = reader(connection);
        return gson.fromJson(response, InitAttributes.class);
    }

    public static Event readEvent(HttpURLConnection connection) {
        String response = reader(connection);
        return gson.fromJson(response, Event.class);
    }
    public static String readSenderResponse(HttpURLConnection connection) {
        return reader(connection);
    }

    public static HttpURLConnection connectionSetup(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "multipart/form-data");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setConnectTimeout(0);
            connection.connect();

            return connection;
        } catch (IOException e) {
            System.out.println("Ошибка настройки соединения!");
        }
        throw new RuntimeException("Не смогли получить connection!");
    }

    private static String reader(HttpURLConnection connection) {
        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {

        }

        return response.toString();
    }
}
