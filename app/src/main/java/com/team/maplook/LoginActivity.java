package com.team.maplook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btn_login_register = (Button) findViewById(R.id.btn_login_register);
        Button btn_login_login =(Button)findViewById(R.id.btn_login_login);
        Button btn_login_forgetpwd = (Button) findViewById(R.id.btn_login_forgetpwd);
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
                Toast.makeText(LoginActivity.this,"正在登陆",Toast.LENGTH_SHORT).show();;
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
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
