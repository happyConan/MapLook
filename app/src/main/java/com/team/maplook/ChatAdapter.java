package com.team.maplook;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jingtaohuang on 16/7/22.
 */
public class ChatAdapter extends BaseAdapter {

    public static final int VALUE_FROM_WORD = 0;  //4种不同的布局
    public static final int VALUE_FROM_PICTURE = 1;
    public static final int VALUE_TO_WORD=2;
    public static final int VALUE_TO_PICTURE=3;
    private LayoutInflater layoutInflater;

    private List<ChatMember> chatMemberList;

    public ChatAdapter(Context context,List<ChatMember> chatMemberList) {
        this.chatMemberList = chatMemberList;
        layoutInflater = (LayoutInflater) context.
                getSystemService(context.LAYOUT_INFLATER_SERVICE);
        
    }

    @Override
    public int getCount() {
        return chatMemberList.size();
    }

    @Override
    public Object getItem(int i) {
        return chatMemberList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        
        ChatMember chatMember = chatMemberList.get(i);
        int type = getItemViewType(i);

        ViewHolderFromWord holderFromWord = null;
        ViewHolderFromPicture holderFromPicture = null;
        ViewHolderToWord holderToWord = null;
        ViewHolderToPicture holderToPicture = null;

        if(view == null){
            switch (type){
                case VALUE_FROM_WORD: //左边文本
                    holderFromWord = new ViewHolderFromWord();
                    view = layoutInflater.inflate(R.layout.listview_chat_fromword_item,null);
                    holderFromWord.tv_chat_fromword_time =
                            (TextView)view.findViewById(R.id.tv_chat_fromword_time);
                    holderFromWord.image_chat_fromword_hp =
                            (ImageButton) view.findViewById(R.id.image_chat_fromword_hp);
//                    holderFromWord.tv_chat_fromword_name =
//                            (TextView)view.findViewById(R.id.tv_chat_fromword_name);
                    holderFromWord.tv_chat_fromword_info =
                            (TextView)view.findViewById(R.id.tv_chat_fromword_info);
                    holderFromWord.tv_chat_fromword_time.setText(chatMember.getChat_time());
                    holderFromWord.image_chat_fromword_hp.setBackgroundResource(chatMember.getChat_hp());
//                    holderFromWord.tv_chat_fromword_name.setText(chatMember.getChat_name());
                    holderFromWord.tv_chat_fromword_info.setText(chatMember.getChat_info_word());
                    view.setTag(holderFromWord);
                    break;
                case VALUE_FROM_PICTURE:  //左边图像
                    holderFromPicture = new ViewHolderFromPicture();
                    view = layoutInflater.inflate(R.layout.listview_chat_frompicture_item,null);
                    holderFromPicture.tv_chat_frompicture_time =
                            (TextView)view.findViewById(R.id.tv_chat_frompicture_time);
                    holderFromPicture.image_chat_frompicture_hp =
                            (ImageButton) view.findViewById(R.id.image_chat_frompicture_hp);
//                    holderFromPicture.tv_chat_frompicture_name =
//                            (TextView)view.findViewById(R.id.tv_chat_frompicture_name);
                    holderFromPicture.image_chat_frompicture_info =
                            (ImageView)view.findViewById(R.id.image_chat_frompicture_info);
                    holderFromPicture.tv_chat_frompicture_time.setText(chatMember.getChat_time());
                    holderFromPicture.image_chat_frompicture_hp.setBackgroundResource(chatMember.getChat_hp());
//                    holderFromPicture.tv_chat_frompicture_name.setText(chatMember.getChat_name());
                    holderFromPicture.image_chat_frompicture_info.setBackgroundResource(chatMember.getChat_info_picture());
                    view.setTag(holderFromPicture);
                    break;
                case VALUE_TO_WORD:     //右边文本
                    holderToWord = new ViewHolderToWord();
                    view = layoutInflater.inflate(R.layout.listview_chat_toword_item,null);
                    holderToWord.tv_chat_toword_time =
                            (TextView)view.findViewById(R.id.tv_chat_toword_time);
                    holderToWord.image_chat_toword_hp =
                            (ImageButton) view.findViewById(R.id.image_chat_toword_hp);
//                    holderToWord.tv_chat_toword_name =
//                            (TextView)view.findViewById(R.id.tv_chat_toword_name);
                    holderToWord.tv_chat_toword_info =
                            (TextView)view.findViewById(R.id.tv_chat_toword_info);
                    holderToWord.tv_chat_toword_time.setText(chatMember.getChat_time());
                    holderToWord.image_chat_toword_hp.setBackgroundResource(chatMember.getChat_hp());
//                    holderToWord.tv_chat_toword_name.setText(chatMember.getChat_name());
                    holderToWord.tv_chat_toword_info.setText(chatMember.getChat_info_word());
                    view.setTag(holderToWord);
                    break;
                case VALUE_TO_PICTURE:  //右边图像
                    holderToPicture = new ViewHolderToPicture();
                    view = layoutInflater.inflate(R.layout.listview_chat_topicture_item,null);
                    holderToPicture.tv_chat_topicture_time =
                            (TextView)view.findViewById(R.id.tv_chat_topicture_time);
                    holderToPicture.image_chat_toicture_hp =
                            (ImageButton)view.findViewById(R.id.image_chat_topicture_hp);
//                    holderToPicture.tv_chat_topicture_name =
//                            (TextView) view.findViewById(R.id.tv_chat_topicture_name);
                    holderToPicture.image_chat_topicture_info =
                            (ImageView)view.findViewById(R.id.image_chat_topicture_info);
                    holderToPicture.tv_chat_topicture_time.setText(chatMember.getChat_time());
                    holderToPicture.image_chat_toicture_hp.setBackgroundResource(chatMember.getChat_hp());
//                    holderToPicture.tv_chat_topicture_name.setText(chatMember.getChat_name());
                    holderToPicture.image_chat_topicture_info.setBackgroundResource(chatMember.getChat_info_picture());
                    view.setTag(holderToPicture);
                    break;
                default:
                    break;
            }
        }else{
            Log.d("baseAdapter","Adapter_:"+(view==null));
            switch (type){
                case VALUE_FROM_WORD: //左边文本
                    holderFromWord = (ViewHolderFromWord)view.getTag();
                    holderFromWord.tv_chat_fromword_time.setText(chatMember.getChat_time());
                    holderFromWord.image_chat_fromword_hp.setBackgroundResource(chatMember.getChat_hp());
//                    holderFromWord.tv_chat_fromword_name.setText(chatMember.getChat_name());
                    holderFromWord.tv_chat_fromword_info.setText(chatMember.getChat_info_word());

                    break;
                case VALUE_FROM_PICTURE:  //左边图像
                    holderFromPicture = (ViewHolderFromPicture)view.getTag();
                    holderFromPicture.tv_chat_frompicture_time.setText(chatMember.getChat_time());
                    holderFromPicture.image_chat_frompicture_hp.setBackgroundResource(chatMember.getChat_hp());
//                    holderFromPicture.tv_chat_frompicture_name.setText(chatMember.getChat_name());
                    holderFromPicture.image_chat_frompicture_info.setImageResource(chatMember.getChat_info_picture());
                    break;
                case VALUE_TO_WORD:     //右边文本
                    holderToWord = (ViewHolderToWord)view.getTag();
                    holderToWord.tv_chat_toword_time.setText(chatMember.getChat_time());
                    holderToWord.image_chat_toword_hp.setBackgroundResource(chatMember.getChat_hp());
//                    holderToWord.tv_chat_toword_name.setText(chatMember.getChat_name());
                    holderToWord.tv_chat_toword_info.setText(chatMember.getChat_info_word());
                    break;
                case VALUE_TO_PICTURE:  //右边图像
                    holderToPicture = (ViewHolderToPicture)view.getTag();
                    holderToPicture.tv_chat_topicture_time.setText(chatMember.getChat_time());
                    holderToPicture.image_chat_toicture_hp.setBackgroundResource(chatMember.getChat_hp());
//                    holderToPicture.tv_chat_topicture_name.setText(chatMember.getChat_name());
                    holderToPicture.image_chat_topicture_info.setBackgroundResource(chatMember.getChat_info_picture());
                    break;
                default:
                    break;

            }
        }
        return view;
        
    }
    @Override
    public int getItemViewType(int position) {
        ChatMember chatMember = chatMemberList.get(position);
        int type = chatMember.getChat_type();
        Log.e("TYPE:",""+type);
        return type;
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }
    
    class ViewHolderFromWord{       //左边文本
        private TextView tv_chat_fromword_time;
        private ImageView image_chat_fromword_hp;
//        private TextView tv_chat_fromword_name;
        private TextView tv_chat_fromword_info;
    }
    class ViewHolderFromPicture{    //左边图像
        private TextView tv_chat_frompicture_time;
        private ImageButton image_chat_frompicture_hp;
//        private TextView tv_chat_frompicture_name;
        private ImageView image_chat_frompicture_info;
    }
    class ViewHolderToWord{     //右边文本
        private TextView tv_chat_toword_time;
        private ImageView image_chat_toword_hp;
//        private TextView tv_chat_toword_name;
        private TextView tv_chat_toword_info;
    }
    class ViewHolderToPicture{  //右边图像
        private TextView tv_chat_topicture_time;
        private ImageButton image_chat_toicture_hp;
//        private TextView tv_chat_topicture_name;
        private ImageView image_chat_topicture_info;
    }
}
