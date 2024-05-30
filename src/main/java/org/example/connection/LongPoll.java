package org.example.connection;

import org.example.handler.ApiHelper;
import org.example.model.Event;
import org.example.model.InitAttributes;
import org.example.utils.RequestBuilder;

import java.net.HttpURLConnection;
import java.util.HashSet;
import java.util.Set;


public class LongPoll {
    private final RequestBuilder requestBuilder = new RequestBuilder();
    private final InitAttributes attribute;
    public static volatile Set<String> previousTs = new HashSet<>();

    public LongPoll(InitAttributes attribute) {
        this.attribute = attribute;
    }

    public void startMonitoring() {

        while(true) {

            String urlObserve = requestBuilder.createObservationRequest(attribute);
            HttpURLConnection connectionObserver = ApiHelper.connectionSetup(urlObserve);
            Event event = ApiHelper.readEvent(connectionObserver);
            attribute.setTs(event.getTs());


            if(!previousTs.contains(attribute.getTs())) {
                synchronized (LongPoll.class) {
                    if (!previousTs.contains(attribute.getTs())) {
                        previousTs.add(attribute.getTs());
                        Event.Message message = event.getMessage();
                        if (!message.getText().equals("-1")) {
                            Thread thread = new Thread(() -> {

                                String urlSender = requestBuilder.createSendRequest(message);
                                
                                HttpURLConnection connectionSender = ApiHelper.connectionSetup(urlSender);
                                String apiResponse = ApiHelper.readSenderResponse(connectionSender);

                                System.out.println(apiResponse);

                                    System.out.println("Я ответил: " + event.getMessage().getText() + "!");

                                connectionSender.disconnect();
                            });
                            thread.start();
                        }
                    }

                }
            }

        }


    }


}