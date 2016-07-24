package com.team.maplook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class PersonalCardActivity extends Activity {

    Name_Receiver name_Receiver;
    Description_Receiver description_Receiver;
    TextView id_c_card_name;
    TextView id_c_card_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_card);

        id_c_card_name = (TextView) findViewById(R.id.id_c_card_name);
        id_c_card_description = (TextView) findViewById(R.id.id_c_card_description);
        Button btn_alter_icon = (Button)findViewById(R.id.btn_alter_icon);
        Button btn_alter_info = (Button)findViewById(R.id.btn_alter_info);

        btn_alter_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //-------尚未实现----------要跳转到修改头像界面：拍照/相册选择

            }
        });

        btn_alter_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_alter_info = new Intent();
                intent_alter_info.setClass(PersonalCardActivity.this,AlterActivity.class);
                startActivity(intent_alter_info);
            }
        });

        //动态注册
        name_Receiver = new Name_Receiver();
        description_Receiver = new Description_Receiver();

        IntentFilter name_filter = new IntentFilter();
        name_filter.addAction("com.team.maplook");
        IntentFilter description_filter = new IntentFilter();
        description_filter.addAction("com.jiaoda.maplook");

        registerReceiver(name_Receiver,name_filter);
        registerReceiver(description_Receiver,description_filter);
    }

    //创建 昵称的广播接收器
    class Name_Receiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent_name) {
            String name = intent_name.getStringExtra("name");
            id_c_card_name.setText(name);
        }
    }

    //创建 个人说明的广播接收器
    class Description_Receiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent_description) {
            String description = intent_description.getStringExtra("description");
            id_c_card_description.setText(description);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(name_Receiver);
        unregisterReceiver(description_Receiver);
    }
}
