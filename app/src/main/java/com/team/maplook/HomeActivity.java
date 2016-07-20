package com.team.maplook;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
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
    private RelativeLayout message_layout;
    private RelativeLayout contacts_layout;
    private RelativeLayout discovery_layout;
    private RelativeLayout setting_layout;
    //定义底部导航栏中的ImageView与TextView
    private ImageView message_image;
    private ImageView contacts_image;
    private ImageView discovery_image;
    private ImageView setting_image;
    private TextView message_text;
    private TextView discovery_text;
    private TextView contacts_text;
    private TextView setting_text;
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
        message_image = (ImageView) findViewById(R.id.message_image);
        contacts_image = (ImageView) findViewById(R.id.contacts_image);
        discovery_image = (ImageView) findViewById(R.id.discovery_image);
        setting_image = (ImageView) findViewById(R.id.setting_image);
        message_text = (TextView) findViewById(R.id.message_text);
        contacts_text = (TextView) findViewById(R.id.contacts_text);
        discovery_text = (TextView) findViewById(R.id.discovery_text);
        setting_text = (TextView) findViewById(R.id.setting_text);
        message_layout = (RelativeLayout) findViewById(R.id.message_layout);
        contacts_layout = (RelativeLayout) findViewById(R.id.contacts_layout);
        discovery_layout = (RelativeLayout) findViewById(R.id.discovery_layout);
        setting_layout = (RelativeLayout) findViewById(R.id.setting_layout);
        message_layout.setOnClickListener(this);
        contacts_layout.setOnClickListener(this);
        discovery_layout.setOnClickListener(this);
        setting_layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.message_layout:
                setChioceItem(0);
                break;
            case R.id.contacts_layout:
                setChioceItem(1);
                break;
            case R.id.discovery_layout:
                setChioceItem(2);
                break;
            case R.id.setting_layout:
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
            case 0:
                message_image.setImageResource(R.drawable.ic_tabbar_message_pressed);
                message_text.setTextColor(green);
//                message_layout.setBackgroundResource(R.mipmap.ic_launcher);
                if (messageFragment == null) {
                    // 如果messageFragment为空，则创建一个并添加到界面上
                    messageFragment = new MessageFragment();
                    transaction.add(R.id.content, messageFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(messageFragment);
                }
                break;
            case 1:
                contacts_image.setImageResource(R.drawable.ic_tabbar_contacts_pressed);
                contacts_text.setTextColor(green);
//                contacts_layout.setBackgroundResource(R.mipmap.ic_launcher);
                if (contactsFragment == null) {
                    // 如果contactsFragment为空，则创建一个并添加到界面上
                    contactsFragment = new ContactsFragment();
                    transaction.add(R.id.content, contactsFragment);
                } else {
                    // 如果ContactsFragment不为空，则直接将它显示出来
                    transaction.show(contactsFragment);
                }
                break;
            case 2:
                discovery_image.setImageResource(R.drawable.ic_tabbar_discovery_pressed);
                discovery_text.setTextColor(green);
//                discovery_layout.setBackgroundResource(R.mipmap.ic_launcher);
                if (discoveryFragment == null) {
                    // 如果discoveryFragment为空，则创建一个并添加到界面上
                    discoveryFragment = new DiscoveryFragment();
                    transaction.add(R.id.content, discoveryFragment);
                } else {
                    // 如果DiscoveryFragment不为空，则直接将它显示出来
                    transaction.show(discoveryFragment);
                }
                break;
            case 3:
                setting_image.setImageResource(R.drawable.ic_tabbar_setting_pressed);
                setting_text.setTextColor(green);
                if(settingFragment == null){
                    // 如果settingFragment为空，则创建一个并添加到界面上
                    settingFragment = new SettingFragment();
                    transaction.add(R.id.content,settingFragment);
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
        message_image.setImageResource(R.drawable.ic_tabbar_message_normal);
//        message_layout.setBackgroundColor(whirt);
        message_text.setTextColor(gray);
        contacts_image.setImageResource(R.drawable.ic_tabbar_contacts_normal);
//        contacts_layout.setBackgroundColor(whirt);
        contacts_text.setTextColor(gray);
        discovery_image.setImageResource(R.drawable.ic_tabbar_discovery_normal);
//        discovery_layout.setBackgroundColor(whirt);
        discovery_text.setTextColor(gray);
        setting_image.setImageResource(R.drawable.ic_tabbar_setting_normal);
//        discovery_layout.setBackgroundColor(whirt);
        setting_text.setTextColor(gray);
    }



}
