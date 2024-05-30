package org.example.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Event {
    private String ts;

    @SerializedName("updates")
    private List<Update> updates;

    public String getTs() {
        return ts;
    }

    public Message getMessage() {
        if(updates.size()==0) {
            Message message = new Message();
            message.setText("-1");
            return message;
        }
        return updates.get(0).object.message;
    }

    public List<Update> getUpdates() {
        return updates;
    }

    public static class Update {
        @SerializedName("group_id")
        private int groupId;

        @SerializedName("type")
        private String type;

        @SerializedName("event_id")
        private String eventId;

        @SerializedName("v")
        private String v;

        @SerializedName("object")
        private Object object;

        public int getGroupId() {
            return groupId;
        }

        public String getType() {
            return type;
        }

        public String getEventId() {
            return eventId;
        }

        public String getV() {
            return v;
        }

        public Object getObject() {
            return object;
        }
    }

    public static class Object {
        @SerializedName("message")
        private Message message;

        @SerializedName("client_info")
        private ClientInfo clientInfo;

        public Message getMessage() {
            return message;
        }

        public ClientInfo getClientInfo() {
            return clientInfo;
        }
    }

    public static class Message {
        @SerializedName("date")
        private long date;

        @SerializedName("from_id")
        private int fromId;

        @SerializedName("id")
        private int id;

        @SerializedName("out")
        private int out;

        @SerializedName("version")
        private int version;

        @SerializedName("attachments")
        private List<Attachment> attachments;

        @SerializedName("conversation_message_id")
        private int conversationMessageId;

        @SerializedName("fwd_messages")
        private List<FwdMessage> fwdMessages;

        @SerializedName("important")
        private boolean important;

        @SerializedName("is_hidden")
        private boolean isHidden;

        @SerializedName("peer_id")
        private long peerId;

        @SerializedName("random_id")
        private int randomId;

        @SerializedName("text")
        private String text;

        @SerializedName("is_unavailable")
        private boolean isUnavailable;

        public long getDate() {
            return date;
        }

        public int getFromId() {
            return fromId;
        }

        public int getId() {
            return id;
        }

        public int getOut() {
            return out;
        }

        public int getVersion() {
            return version;
        }

        public List<Attachment> getAttachments() {
            return attachments;
        }

        public int getConversationMessageId() {
            return conversationMessageId;
        }

        public List<FwdMessage> getFwdMessages() {
            return fwdMessages;
        }

        public boolean isImportant() {
            return important;
        }

        public boolean isHidden() {
            return isHidden;
        }

        public long getPeerId() {
            return peerId;
        }

        public int getRandomId() {
            return randomId;
        }

        public String getText() {
            return text;
        }

        public boolean isUnavailable() {
            return isUnavailable;
        }


        public void setText(String text) {
            this.text = text;
        }
    }

    public static class ClientInfo {
        @SerializedName("button_actions")
        private List<String> buttonActions;

        @SerializedName("keyboard")
        private boolean keyboard;

        @SerializedName("inline_keyboard")
        private boolean inlineKeyboard;

        @SerializedName("carousel")
        private boolean carousel;

        @SerializedName("lang_id")
        private int langId;

        // getters and setters
    }

    public static class Attachment {
        // add fields and getters/setters as needed
    }

    public static class FwdMessage {
        // add fields and getters/setters as needed
    }
}

