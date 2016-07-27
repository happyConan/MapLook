package com.team.maplook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShowAccountActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_account);

        Button btn_showaccount_backtologin = (Button)findViewById(R.id.btn_showaccount_backtologin);
        btn_showaccount_backtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ShowAccountActivity.this,LoginActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }

}
