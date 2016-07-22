package com.team.maplook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btn_gotoregister = (Button) findViewById(R.id.btn_gotoregister);
        Button btn_login =(Button)findViewById(R.id.btn_login);
        Button btn_forgetpwd = (Button) findViewById(R.id.btn_forgetpwd);
        btn_gotoregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this,"正在登陆",Toast.LENGTH_SHORT).show();;
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        btn_forgetpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });


    }
}
