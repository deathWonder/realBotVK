package org.example.bot;

import org.example.connection.LongPoll;
import org.example.initialization.Initialization;
import org.example.model.InitAttributes;
import org.example.utils.RequestBuilder;

public class VKBot {

    public void start() {
        System.out.println("Чтение конфигурационного файла...");
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.init();

        System.out.println("Получение ключу доступа...");
        Initialization initialization = new Initialization();
        InitAttributes attribute = initialization.getPermission();


        System.out.println("Начинаю наблюдение...");
        LongPoll longPoll = new LongPoll(attribute);
        longPoll.startMonitoring();
    }
}
