package com.team.maplook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResetPasswordActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        Button btn_reset_pwd = (Button) findViewById(R.id.btn_reset_password);
        btn_reset_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ResetPasswordActivity.this,LoginActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }

}
