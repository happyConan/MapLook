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

        contactsMemberList.add(new ContactsMember(R.drawable.image_contacts_hp_1,
                context.getString(R.string.tv_contacts_name_1)));
        contactsMemberList.add(new ContactsMember(R.drawable.image_contacts_hp_2,
                context.getString(R.string.tv_contacts_name_2)));
        contactsMemberList.add(new ContactsMember(R.drawable.image_contacts_hp_3,
                context.getString(R.string.tv_contacts_name_3)));

//        contactsMemberList.add(new ContactsMember(R.drawable.ic_hjt,"你好像很好吃"));
//        contactsMemberList.add(new ContactsMember(R.drawable.ic_sjp,"嗯哼嗯哼大王嗬嗬哈嘿"));
//        contactsMemberList.add(new ContactsMember(R.drawable.ic_wf,"子丑寅卯"));
//        contactsMemberList.add(new ContactsMember(R.drawable.ic_wg,"向前走，无所畏"));
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
        TextView contacts_name = (TextView)view.findViewById(R.id.tv_contacts_name);
        ImageView contacts_image = (ImageView)view.findViewById(R.id.image_contacts_hp);
        contacts_name.setText(contactsMember.getContacts_name());
        contacts_image.setImageResource(contactsMember.getContacts_image());
        return view;
    }
}
