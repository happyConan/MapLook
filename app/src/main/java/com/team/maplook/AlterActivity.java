package com.team.maplook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.team.maplook.databaseUtil.SqliteOperate;

public class AlterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alter);

        Button btn_alter_save = (Button)findViewById(R.id.btn_alter_save);
        final EditText et_alter_name = (EditText)findViewById(R.id.et_alter_name);
        final EditText et_alter_discription = (EditText)findViewById(R.id.et_alter_discription);
        final EditText pwd=(EditText)findViewById(R.id.id_c_alter_pwd) ;
        String[] s=SqliteOperate.QueryDatabase(AlterActivity.this,SqliteOperate.mAccount);
        et_alter_name.setText(s[0]);
        et_alter_discription.setText(s[2]);
        pwd.setText(s[3]);


        btn_alter_save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String alter_name = et_alter_name.getText().toString();
                String alter_description = et_alter_discription.getText().toString();
                String pass=pwd.getText().toString();

                SqliteOperate.updateDatabase(SqliteOperate.mAccount,AlterActivity.this,alter_name,alter_description,pass);
                Toast.makeText(AlterActivity.this,"修改成功",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent();
                intent.setClass(AlterActivity.this,PersonalCardActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
