package com.team.maplook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alter);

        Button btn_alter_save = (Button)findViewById(R.id.btn_alter_save);
        final EditText et_alter_name = (EditText)findViewById(R.id.et_alter_name);
        final EditText et_alter_discription = (EditText)findViewById(R.id.et_alter_discription);

        btn_alter_save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String alter_name = et_alter_name.getText().toString();
                String alter_description = et_alter_discription.getText().toString();

                Intent intent_name = new Intent();
                intent_name.setAction("com.team.maplook");
                Intent intent_description = new Intent();
                intent_description.setAction("com.jiaoda.maplook");

                intent_name.putExtra("name",alter_name);
                sendBroadcast(intent_name);
                intent_description.putExtra("description",alter_description);
                sendBroadcast(intent_description);

                finish();
            }
        });
    }

}
