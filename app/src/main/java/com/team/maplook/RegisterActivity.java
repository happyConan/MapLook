package com.team.maplook;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.team.maplook.databaseUtil.SqliteOperate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class RegisterActivity extends Activity {

    private ImageView hp;
    private Bitmap head;//头像Bitmap
    private static String path="/sdcard/myHead/";//sd路径
    private EditText password;
    private EditText birth;
    private EditText confirmPass;
    private EditText farName;
    private EditText nickname;
    private Spinner gender;
    private String sex;
    private Button btn_register_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        head= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        initView();


    }

    private void initView() {
        hp=(ImageView)findViewById(R.id.image_register_hp);
        btn_register_register = (Button)findViewById(R.id.btn_register_register);
        password=(EditText)findViewById(R.id.et_login_pwd);
        birth=(EditText)findViewById(R.id.tv_register_secureanswer1);
        confirmPass=(EditText)findViewById(R.id.et_register_confirmpwd);
        farName=(EditText)findViewById(R.id.tv_register_secureanswer2);
        nickname=(EditText)findViewById(R.id.tv_register_nickname1);
        gender=(Spinner)findViewById(R.id.sp_register_gender_array);



        gender.setOnItemSelectedListener(new Spinner.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sex=parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        hp.setOnClickListener(new ImageListener());
        btn_register_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=nickname.getText().toString();
                String pwd=password.getText().toString();
                String fatherNme=farName.getText().toString();
                String birthday=birth.getText().toString();
                String conPwd=confirmPass.getText().toString();
                String account=(SqliteOperate.getCount(RegisterActivity.this)+1000000)+"";

                if(name.equals("")||pwd.equals("")||fatherNme.equals("")||birthday.equals("")||conPwd.equals(""))
                {
                    Toast.makeText(RegisterActivity.this,"请将上述信息填写完整",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(pwd.equals(conPwd)) {
                    SqliteOperate.InsertDatabase(RegisterActivity.this, account,name, sex, birthday, fatherNme, pwd, head);
                    Toast.makeText(RegisterActivity.this,"恭喜您注册成功",Toast.LENGTH_SHORT).show();
                    Intent intent  = new Intent();
                    intent.setClass(RegisterActivity.this,ShowAccountActivity.class);
                    intent.putExtra("account",account);
                    startActivity(intent);
                    RegisterActivity.this.finish();
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "密码输入不一致，请重新输入", Toast.LENGTH_SHORT).show();
                }

                }
            }



        });






    }


    class ImageListener implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {
            String title = "选择获取图片方式";

            String[] items = new String[]{"拍照","相册"};
            new AlertDialog.Builder(RegisterActivity.this)
                    .setTitle(title)
                    .setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            switch (i)
                            {
                                case 1:
                                    Intent intent1 = new Intent(Intent.ACTION_PICK, null);
                                    intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                                    startActivityForResult(intent1, 1);
                                    break;
                                case 0:
                                    Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                    intent2.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment.getExternalStorageDirectory(),
                                            "head.jpg")));
                                    startActivityForResult(intent2, 2);//采用ForResult打开
                                    break;
                                default:break;
                            }

                        }
                    }).show();
        }
    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode != RESULT_CANCELED)
        {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    cropPhoto(data.getData());//裁剪图片
                }

                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    File temp = new File(Environment.getExternalStorageDirectory()
                            + "/head.jpg");
                    cropPhoto(Uri.fromFile(temp));//裁剪图片
                }

                break;
            case 3:
                if (data != null) {
                    Bundle extras = data.getExtras();
                    head = extras.getParcelable("data");
                    if (head != null) {

                        setPicToView(head);//保存在SD卡中
                        hp.setImageBitmap(head);//用ImageView显示出来
                    }
                }
                break;
            default:
                break;

        }
    }
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 3);
    }
    private void setPicToView(Bitmap mBitmap) {
        String sdStatus = Environment.getExternalStorageState();
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
            return;
        }
        FileOutputStream b = null;
        File file = new File(path);
        file.mkdirs();// 创建文件夹
        String fileName =path + "head.jpg";//图片名字
        try {
            b = new FileOutputStream(fileName);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                b.flush();
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
