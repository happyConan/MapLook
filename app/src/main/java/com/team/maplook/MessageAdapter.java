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
        messageMemberList.add(new MessageMember(context.getString(R.string.tv_message_name_1),
                R.drawable.image_message_ic_1,
                context.getString(R.string.tv_message_message_1),
                context.getString(R.string.tv_message_time_1)));
        messageMemberList.add(new MessageMember(context.getString(R.string.tv_message_name_2),
                R.drawable.image_message_ic_2,
                context.getString(R.string.tv_message_message_2),
                context.getString(R.string.tv_message_time_2)));
        messageMemberList.add(new MessageMember(context.getString(R.string.tv_message_name_3),
                R.drawable.image_message_ic_3,
                context.getString(R.string.tv_message_message_3),
                context.getString(R.string.tv_message_time_3)));
//        messageMemberList.add(new MessageMember("嗯哼嗯哼大王嗬嗬哈嘿",R.drawable.ic_sjp,"晚安！加油","23:56"));
//        messageMemberList.add(new MessageMember("交大Android短期培训",R.drawable.ic_class,"计算机宋光磊:@z 谢谢","20:33"));
//        messageMemberList.add(new MessageMember("安卓小分队2333",R.drawable.ic_group,"嗯。。。","14:08"));
//        messageMemberList.add(new MessageMember("子丑寅卯",R.drawable.ic_wf,"好，谢谢","昨天"));
//        messageMemberList.add(new MessageMember("你好像很好吃",R.drawable.ic_hjt,"不喜欢你了","星期三"));
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
        TextView message_name = (TextView)view.findViewById(R.id.tv_message_name);
        ImageView message_image = (ImageView)view.findViewById(R.id.image_message_ic);
        TextView message_message = (TextView)view.findViewById(R.id.tv_message_message);
        TextView message_time = (TextView) view.findViewById(R.id.tv_message_time);
        message_name.setText(messageMember.getMessage_name());
        message_image.setImageResource(messageMember.getMessage_image());
        message_message.setText(messageMember.getMessage_message());
        message_time.setText(messageMember.getMessage_time());
        return view;
    }
}
