package org.example.utils;

import org.example.model.Event;
import org.example.model.InitAttributes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class RequestBuilder {
    private static String ACCESS_TOKEN;
    private static String VERSION;
    private static String GROUP_ID;
    private static final String INIT_BASE_URL = "https://api.vk.com/method/groups.getLongPollServer?";
    private static final String SEND_BASE_URL = "https://api.vk.com/method/messages.send?";

    public void init() {
        Properties prop = new Properties();
        String fileName = "settings";
        try (FileInputStream fis = new FileInputStream(fileName)) {
            prop.load(fis);
        } catch (FileNotFoundException ex) {
            System.out.println("Не нашел конфигурационный файл");
        } catch (IOException ex) {
            System.out.println("Ошибка чтения");
        }
        ACCESS_TOKEN = prop.getProperty("access_token");
        VERSION = prop.getProperty("version");
        GROUP_ID = prop.getProperty("group_id");

    }
    public String createInitRequest() {
        return INIT_BASE_URL + "access_token=" + ACCESS_TOKEN + "&v=" + VERSION + "&group_id=" + GROUP_ID;
    }

    public String createObservationRequest(InitAttributes attribute) {
        return attribute.getServer()
                + "?act=a_check&" +"key="+ attribute.getKey()+"&ts="+ attribute.getTs()+"&wait=10";
    }

    public String createSendRequest(Event.Message message) {

        String letter = "Вы сказали:" + message.getText();

        return SEND_BASE_URL + "access_token="
                + ACCESS_TOKEN
                +"&message=" + letter + "&random_id="
                + message.getRandomId()+
                "&v=5.81" + "&peer_id="
                + message.getPeerId()
                + "&group_id="+GROUP_ID;
    }
}
