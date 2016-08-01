package com.team.maplook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.team.maplook.databaseUtil.SqliteOperate;

public class ResetPasswordActivity extends Activity {

    private EditText password;
    private EditText confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        Intent intent=getIntent();
        final String account=intent.getStringExtra("account");

        password=(EditText)findViewById(R.id.et_resetpassword_save) ;
        confirm=(EditText)findViewById(R.id.et_resetpassword_confirm) ;


        Button btn_resetpassword_save = (Button) findViewById(R.id.btn_resetpassword_save);
        btn_resetpassword_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pwd=password.getText().toString();
                String con=confirm.getText().toString();
                if(pwd.equals(con))
                {
                    SqliteOperate.updateDatabase(account,ResetPasswordActivity.this,pwd);
                    Toast.makeText(ResetPasswordActivity.this,"密码修改成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(ResetPasswordActivity.this,LoginActivity.class);
                finish();
                startActivity(intent);}
                else
                {
                    Toast.makeText(ResetPasswordActivity.this, "密码输入不一致，请重新输入", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
