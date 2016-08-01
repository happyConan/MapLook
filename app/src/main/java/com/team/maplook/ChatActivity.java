package com.team.maplook;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends Activity {
    private ListView lv_chat_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        lv_chat_content = (ListView)findViewById(R.id.lv_chat_content);
        lv_chat_content.setAdapter(getAdapter());
        
    }
    private BaseAdapter getAdapter(){
        return new ChatAdapter(this,getMyData());
    }
    private List<ChatMember> getMyData(){
        List<ChatMember> chatMemberList = new ArrayList<ChatMember>();
        ChatMember chatMember;
        
        chatMember = new ChatMember();
        chatMember.setChat_type(ChatAdapter.VALUE_TO_WORD);
        chatMember.setChat_time(getString(R.string.tv_chat_toword_time));
        chatMember.setChat_hp(R.drawable.image_chat_to_hp);
//        chatMember.setChat_name(getString(R.string.tv_chat_to_name));
        chatMember.setChat_info_word(getString(R.string.tv_chat_toword_info));
        chatMemberList.add(chatMember);

        chatMember = new ChatMember();
        chatMember.setChat_type(ChatAdapter.VALUE_FROM_WORD);
        chatMember.setChat_time(getString(R.string.tv_chat_fromword_time));
        chatMember.setChat_hp(R.drawable.image_chat_from_hp);
//        chatMember.setChat_name(getString(R.string.tv_chat_from_name));
        chatMember.setChat_info_word(getString(R.string.tv_chat_fromword_info));
        chatMemberList.add(chatMember);

        chatMember = new ChatMember();
        chatMember.setChat_type(ChatAdapter.VALUE_TO_PICTURE);
        chatMember.setChat_time(getString(R.string.tv_chat_topicture_time));
        chatMember.setChat_hp(R.drawable.image_chat_to_hp);
//        chatMember.setChat_name(getString(R.string.tv_chat_to_name));
        chatMember.setChat_info_picture(R.drawable.image_chat_topicture_info);
        chatMemberList.add(chatMember);

        chatMember = new ChatMember();
        chatMember.setChat_type(ChatAdapter.VALUE_FROM_PICTURE);
        chatMember.setChat_time(getString(R.string.tv_chat_frompicture_time));
        chatMember.setChat_hp(R.drawable.image_chat_from_hp);
//        chatMember.setChat_name(getString(R.string.tv_chat_from_name));
        chatMember.setChat_info_picture(R.drawable.image_chat_frompicture_info);
        chatMemberList.add(chatMember);

        return  chatMemberList;
        
        
    }
    
    
}
