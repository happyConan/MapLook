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
public class ContactsAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<ContactsMember> contactsMemberList;

    public ContactsAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        contactsMemberList = new ArrayList<>();
        contactsMemberList.add(new ContactsMember(R.drawable.ic_tabbar_contacts_pressed,"黄景涛"));
        contactsMemberList.add(new ContactsMember(R.drawable.ic_tabbar_contacts_normal,"苏锦萍"));
        contactsMemberList.add(new ContactsMember(R.drawable.ic_tabbar_setting_pressed,"王飞"));
        contactsMemberList.add(new ContactsMember(R.drawable.ic_tabbar_setting_pressed,"王刚"));

    }


    @Override
    public int getCount() {
        return contactsMemberList.size();
    }

    @Override
    public Object getItem(int i) {
        return contactsMemberList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = layoutInflater.inflate(R.layout.listview_contacts_item,viewGroup,false);
        }
        //按照i获取contactsMemberList内的contactsMember对象
        ContactsMember contactsMember = contactsMemberList.get(i);
        //找到成员子组件显示名字、头像、最新消息
        TextView contacts_name = (TextView)view.findViewById(R.id.contacts_name);
        ImageView contacts_image = (ImageView)view.findViewById(R.id.contacts_image);
        contacts_name.setText(contactsMember.getContacts_name());
        contacts_image.setImageResource(contactsMember.getContacts_image());
        return view;
    }
}
