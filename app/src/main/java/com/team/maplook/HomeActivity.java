package com.team.maplook;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HomeActivity extends FragmentActivity implements View.OnClickListener{

    //定义3个Fragment的对象
    private MessageFragment messageFragment;
    private ContactsFragment contactsFragment;
    private DiscoveryFragment discoveryFragment;
    private SettingFragment settingFragment;
    //帧布局对象,就是用来存放Fragment的容器
    private FrameLayout flayout;
    //定义底部导航栏的三个布局
    private RelativeLayout relativelayout_home_message;
    private RelativeLayout relativelayout_home_contacts;
    private RelativeLayout relativelayout_home_discovery;
    private RelativeLayout relativelayout_home_setting;
    //定义底部导航栏中的ImageView与TextView
    private TextView tv_home_title;
    private ImageView image_home_ic_message;
    private ImageView image_home_ic_contacts;
    private ImageView image_home_ic_discovery;
    private ImageView image_home_ic_setting;
    private TextView tv_home_text_message;
    private TextView tv_home_text_discovery;
    private TextView tv_home_text_contacts;
    private TextView tv_home_text_setting;
    //定义要用的颜色值
    private int whirt = 0xFFFFFFFF;
    private int gray = 0xFFDDDDDD;
    private int blue =0xFF0AB2FB;
    private int green =0xFF8BB52F;
    //定义FragmentManager对象
    FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fManager = getSupportFragmentManager();
        initViews();
    }
    //组件初始化
    private void initViews() {
        tv_home_title = (TextView) findViewById(R.id.tv_home_title);
        image_home_ic_message = (ImageView) findViewById(R.id.image_home_ic_message);
        image_home_ic_contacts = (ImageView) findViewById(R.id.image_home_ic_contacts);
        image_home_ic_discovery = (ImageView) findViewById(R.id.image_home_ic_discovery);
        image_home_ic_setting = (ImageView) findViewById(R.id.image_home_ic_setting);
        tv_home_text_message = (TextView) findViewById(R.id.tv_home_text_message);
        tv_home_text_contacts = (TextView) findViewById(R.id.tv_home_text_contacts);
        tv_home_text_discovery = (TextView) findViewById(R.id.tv_home_text_discovery);
        tv_home_text_setting = (TextView) findViewById(R.id.tv_home_text_setting);
        relativelayout_home_message = (RelativeLayout) findViewById(R.id.relativelayout_home_message);
        relativelayout_home_contacts = (RelativeLayout) findViewById(R.id.relativelayout_home_contacts);
        relativelayout_home_discovery = (RelativeLayout) findViewById(R.id.relativelayout_home_discovery);
        relativelayout_home_setting = (RelativeLayout) findViewById(R.id.relativelayout_home_setting);
        relativelayout_home_message.setOnClickListener(this);
        relativelayout_home_contacts.setOnClickListener(this);
        relativelayout_home_discovery.setOnClickListener(this);
        relativelayout_home_setting.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.relativelayout_home_message:
                setChioceItem(0);
                break;
            case R.id.relativelayout_home_contacts:
                setChioceItem(1);
                break;
            case R.id.relativelayout_home_discovery:
                setChioceItem(2);
                break;
            case R.id.relativelayout_home_setting:
                setChioceItem(3);
            default:
                break;
        }
    }

    private void setChioceItem(int index) {
        //重置选项+隐藏所有Fragment
        FragmentTransaction transaction = fManager.beginTransaction();
        clearChioce();
        hideFragments(transaction);
        switch (index) {
            //消息界面
            case 0:
                tv_home_title.setText(R.string.tv_home_title_message);
                image_home_ic_message.setImageResource(R.drawable.image_home_ic_message_pressed);
                tv_home_text_message.setTextColor(green);
//                message_layout.setBackgroundResource(R.mipmap.ic_launcher);
                if (messageFragment == null) {
                    // 如果messageFragment为空，则创建一个并添加到界面上
                    messageFragment = new MessageFragment();
                    transaction.add(R.id.framelayout_home_content, messageFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(messageFragment);
                }
                break;
            //好友界面
            case 1:
                tv_home_title.setText(R.string.tv_home_title_contacts);
                image_home_ic_contacts.setImageResource(R.drawable.image_home_ic_contacts_pressed);
                tv_home_text_contacts.setTextColor(green);
//                contacts_layout.setBackgroundResource(R.mipmap.ic_launcher);
                if (contactsFragment == null) {
                    // 如果contactsFragment为空，则创建一个并添加到界面上
                    contactsFragment = new ContactsFragment();
                    transaction.add(R.id.framelayout_home_content, contactsFragment);
                } else {
                    // 如果ContactsFragment不为空，则直接将它显示出来
                    transaction.show(contactsFragment);
                }
                break;
            //发现界面
            case 2:
                tv_home_title.setText(R.string.tv_home_title_discovery);
                image_home_ic_discovery.setImageResource(R.drawable.image_home_ic_discovery_pressed);
                tv_home_text_discovery.setTextColor(green);
//                discovery_layout.setBackgroundResource(R.mipmap.ic_launcher);
                if (discoveryFragment == null) {
                    // 如果discoveryFragment为空，则创建一个并添加到界面上
                    discoveryFragment = new DiscoveryFragment();
                    transaction.add(R.id.framelayout_home_content, discoveryFragment);
                } else {
                    // 如果DiscoveryFragment不为空，则直接将它显示出来
                    transaction.show(discoveryFragment);
                }
                break;
            //设置界面
            case 3:
                tv_home_title.setText(R.string.tv_home_title_setting);
                image_home_ic_setting.setImageResource(R.drawable.image_home_ic_setting_pressed);
                tv_home_text_setting.setTextColor(green);
                if(settingFragment == null){
                    // 如果settingFragment为空，则创建一个并添加到界面上
                    settingFragment = new SettingFragment();
                    transaction.add(R.id.framelayout_home_content,settingFragment);
                }else {
                    // 如果SettingFragment不为空，则直接将它显示出来
                    transaction.show(settingFragment);
                }
                break;
        }
        transaction.commit();
    }

    //隐藏所有的Fragment,避免fragment混乱
    private void hideFragments(FragmentTransaction transaction) {
        if (messageFragment != null) {
            transaction.hide(messageFragment);
        }
        if (contactsFragment != null) {
            transaction.hide(contactsFragment);
        }
        if (discoveryFragment != null) {
            transaction.hide(discoveryFragment);
        }
        if (settingFragment != null) {
            transaction.hide(settingFragment);
        }
    }


    //定义一个重置所有选项的方法
    public void clearChioce()
    {
        image_home_ic_message.setImageResource(R.drawable.image_home_ic_message_unpressed);
        tv_home_text_message.setTextColor(gray);
        image_home_ic_contacts.setImageResource(R.drawable.image_home_ic_contacts_unpressed);
        tv_home_text_contacts.setTextColor(gray);
        image_home_ic_discovery.setImageResource(R.drawable.image_home_ic_discovery_unpressed);
        tv_home_text_discovery.setTextColor(gray);
        image_home_ic_setting.setImageResource(R.drawable.image_home_ic_setting_unpressed);
        tv_home_text_setting.setTextColor(gray);
    }
}
