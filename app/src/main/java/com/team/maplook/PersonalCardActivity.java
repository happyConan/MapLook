package com.team.maplook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

public class PersonalCardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_card);
        Button btn_alter_icon = (Button)findViewById(R.id.btn_alter_icon);
        Button btn_alter_info = (Button)findViewById(R.id.btn_alter_info);
        btn_alter_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btn_alter_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(PersonalCardActivity.this,AlterActivity.class);
                startActivity(intent);
            }
        });


    }
}
