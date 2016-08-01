package com.team.maplook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.team.maplook.databaseUtil.SqliteOperate;

public class VerifyActivity extends Activity {
    private EditText account;
    private EditText farName;
    private EditText birth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        account=(EditText)findViewById(R.id.tv_verify_account1);
        farName=(EditText)findViewById(R.id.tv_verify_secureanswer2);
        birth=(EditText)findViewById(R.id.tv_verify_secureanswer1);


        Button btn_verify_verify = (Button)findViewById(R.id.btn_verify_verify);
        btn_verify_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ac = account.getText().toString();
                String bir = birth.getText().toString();
                String far = farName.getText().toString();

                account.setText("");
                birth.setText("");
                farName.setText("");


                if(ac.equals("")||bir.equals("")||far.equals(""))
                {
                    Toast.makeText(VerifyActivity.this,"请把上述各项填写完整！",Toast.LENGTH_SHORT).show();
                }
                else
                {
                int result = SqliteOperate.QueryDatabase(VerifyActivity.this, ac, bir, far);

                if (result == -1) {
                    Toast.makeText(VerifyActivity.this, "要找回的账号不存在，请重新输入", Toast.LENGTH_SHORT).show();
                } else if (result == 1) {
                    Intent intent = new Intent();
                    intent.putExtra("account",ac);
                    intent.setClass(VerifyActivity.this, ResetPasswordActivity.class);
                    finish();
                    startActivity(intent);
                } else {
                    Toast.makeText(VerifyActivity.this, "密保问题回答错误", Toast.LENGTH_SHORT).show();

                }
            }


            }
        });
    }
}
