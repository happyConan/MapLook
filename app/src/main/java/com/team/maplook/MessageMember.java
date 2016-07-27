package com.team.maplook;

/**
 * Created by jingtaohuang on 16/7/21.
 */
public class MessageMember {
    String message_name;
    int message_image;
    String message_message;
    String message_time;

    public MessageMember(String message_name, int message_image, String message_message, String message_time) {
        this.message_name = message_name;
        this.message_image = message_image;
        this.message_message = message_message;
        this.message_time = message_time;
    }
    public String getMessage_name() {
        return message_name;
    }

    public int getMessage_image() {
        return message_image;
    }

    public String getMessage_message() {
        return message_message;
    }

    public String getMessage_time() { return message_time; }
}
