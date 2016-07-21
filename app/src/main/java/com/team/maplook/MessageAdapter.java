package com.team.maplook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jingtaohuang on 16/7/21.
 */
public class MessageAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<MessageMember> messageMemberList;

    public MessageAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);
        messageMemberList = new ArrayList<>();
        messageMemberList.add(new MessageMember("安卓小分队",R.drawable.ic_tabbar_message_normal,"你好"));
        messageMemberList.add(new MessageMember("黄景涛",R.drawable.ic_tabbar_message_normal,"Hello"));
        messageMemberList.add(new MessageMember("苏锦萍",R.drawable.ic_tabbar_message_normal,"Hi"));
        messageMemberList.add(new MessageMember("王飞",R.drawable.ic_tabbar_message_normal,"aloha"));
    }


    @Override
    public int getCount() {
        
        return messageMemberList.size();
    }

    @Override
    public Object getItem(int i) {

        return messageMemberList.get(i);
    }

    @Override
    public long getItemId(int i) {

        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = layoutInflater.inflate(R.layout.listview_message_item,viewGroup,false);
        }
        //按照i获取messageMemberList内的messageMember对象
        MessageMember messageMember = messageMemberList.get(i);
        //找到成员子组件显示名字、头像、最新消息
        TextView message_name = (TextView)view.findViewById(R.id.message_name);
        ImageView message_image = (ImageView)view.findViewById(R.id.message_image);
        TextView message_lastestcontent = (TextView)view.findViewById(R.id.message_latestcontent);
        message_name.setText(messageMember.getMessage_name());
        message_image.setImageResource(messageMember.getMessage_image());
        message_lastestcontent.setText(messageMember.getMessage_lastestcontent());
        return view;
    }
}
