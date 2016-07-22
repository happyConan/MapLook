package com.team.maplook;

/**
 * Created by jingtaohuang on 16/7/21.
 */
public class MessageMember {
    String message_name;
    int message_image;
    String message_lastestcontent;
    String message_time;

    public MessageMember(String message_name, int message_image, String message_lastestcontent, String message_time) {
        this.message_name = message_name;
        this.message_image = message_image;
        this.message_lastestcontent = message_lastestcontent;
        this.message_time = message_time;
    }
    public String getMessage_name() {
        return message_name;
    }

    public int getMessage_image() {
        return message_image;
    }

    public String getMessage_lastestcontent() {
        return message_lastestcontent;
    }

    public String getMessage_time() { return message_time; }
}
