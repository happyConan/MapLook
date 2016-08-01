package com.team.maplook;

/**
 * Created by jingtaohuang on 16/7/22.
 */
public class ChatMember {
    private int chat_type;//类型
    private String chat_time;//时间
    private int chat_hp;
//    private String chat_name;
    private String chat_info_word;
    private int chat_info_picture;

    public int getChat_type() {
        return chat_type;
    }

    public String getChat_time() {
        return chat_time;
    }

    public int getChat_hp() {
        return chat_hp;
    }

//    public String getChat_name() {
//        return chat_name;
//    }

    public String getChat_info_word() {
        return chat_info_word;
    }

    public int getChat_info_picture() {
        return chat_info_picture;
    }

    public void setChat_type(int chat_type) {
        this.chat_type = chat_type;
    }

    public void setChat_time(String chat_time) {
        this.chat_time = chat_time;
    }

    public void setChat_hp(int chat_hp) {
        this.chat_hp = chat_hp;
    }

//    public void setChat_name(String chat_name) {
//        this.chat_name = chat_name;
//    }

    public void setChat_info_word(String chat_info_word) {
        this.chat_info_word = chat_info_word;
    }

    public void setChat_info_picture(int chat_info_picture) {
        this.chat_info_picture = chat_info_picture;
    }
}
