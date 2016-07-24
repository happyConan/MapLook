package com.team.maplook;

/**
 * Created by jingtaohuang on 16/7/22.
 */
public class ChatMember {
    String chat_time;
    int chat_image;
    String chat_info;
    String chat_name;

    public ChatMember(String chat_time, int chat_image, String chat_info, String chat_name) {
        this.chat_time = chat_time;
        this.chat_image = chat_image;
        this.chat_info = chat_info;
        this.chat_name = chat_name;
    }

    public String getChat_time() {
        return chat_time;
    }

    public int getChat_image() {
        return chat_image;
    }

    public String getChat_info() {
        return chat_info;
    }

    public String getChat_name() {
        return chat_name;
    }
}
