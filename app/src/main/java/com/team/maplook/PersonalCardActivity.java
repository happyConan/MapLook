package com.team.maplook;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PersonalCardActivity extends Activity {

    Name_Receiver name_Receiver;
    Description_Receiver description_Receiver;
    TextView tv_personalcard_name;
    TextView tv_personalcard_description;
    ImageView hp;//头像
    private Bitmap head;//头像Bitmap
    private static String path="/sdcard/myHead/";//sd路径

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_card);

        hp=(ImageView)findViewById(R.id.id_c_card_icon);
        tv_personalcard_name = (TextView) findViewById(R.id.tv_personalcard_name);
        tv_personalcard_description = (TextView) findViewById(R.id.tv_personalcard_description);
        Button btn_personalcard_alterhp = (Button)findViewById(R.id.btn_personalcard_alterhp);
        Button btn_personalcard_alterinfo = (Button)findViewById(R.id.btn_personalcard_alterinfo);

        btn_personalcard_alterhp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //-------尚未实现----------要跳转到修改头像界面：拍照/相册选择

                String title = "选择获取图片方式";

                String[] items = new String[]{"拍照","相册"};
                new AlertDialog.Builder(PersonalCardActivity.this)
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
        });

        btn_personalcard_alterinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_alter_info = new Intent();
                intent_alter_info.setClass(PersonalCardActivity.this,AlterActivity.class);
                startActivity(intent_alter_info);
            }
        });

        //动态注册
        name_Receiver = new Name_Receiver();
        description_Receiver = new Description_Receiver();

        IntentFilter name_filter = new IntentFilter();
        name_filter.addAction("com.team.maplook");
        IntentFilter description_filter = new IntentFilter();
        description_filter.addAction("com.jiaoda.maplook");

        registerReceiver(name_Receiver,name_filter);
        registerReceiver(description_Receiver,description_filter);
    }

    //创建 昵称的广播接收器
    class Name_Receiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent_name) {
            String name = intent_name.getStringExtra("name");
            tv_personalcard_name.setText(name);
        }
    }

    //创建 个人说明的广播接收器
    class Description_Receiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent_description) {
            String description = intent_description.getStringExtra("description");
            tv_personalcard_description.setText(description);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(name_Receiver);
        unregisterReceiver(description_Receiver);
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
                            /**
                             * 上传服务器代码
                             */
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
    /**
     * 调用系统的裁剪
     * @param uri
     */
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
