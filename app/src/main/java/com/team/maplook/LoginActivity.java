package com.team.maplook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.team.maplook.databaseUtil.SqliteOperate;

public class LoginActivity extends Activity {
    private Button btn_login_register;
    private Button btn_login_login;
    private Button btn_login_forgetpwd;
    private EditText account;
    private EditText pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SqliteOperate.createDatabase(LoginActivity.this);

        account=(EditText)findViewById(R.id.et_login_account);
        pwd=(EditText)findViewById(R.id.et_login_pwd);

        btn_login_register = (Button) findViewById(R.id.btn_login_register);
        btn_login_login =(Button)findViewById(R.id.btn_login_login);
        btn_login_forgetpwd = (Button) findViewById(R.id.btn_login_forgetpwd);
        btn_login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        btn_login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ac=account.getText().toString();
                String pw=pwd.getText().toString();
                pwd.setText("");
                int result=SqliteOperate.QueryDatabase(LoginActivity.this,ac,pw);

                if(result==1)
                {
                    SqliteOperate.mAccount=ac;
                    Toast.makeText(LoginActivity.this,"正在登陆",Toast.LENGTH_SHORT).show();;
                    Intent intent = new Intent();
                    intent.setClass(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);
                }

                else if(result==0)
                {
                    Toast.makeText(LoginActivity.this, "账号不存在", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "密码输入错误", Toast.LENGTH_SHORT).show();
                }


            }
        });
        btn_login_forgetpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,VerifyActivity.class);
                startActivity(intent);
            }
        });


    }
}
