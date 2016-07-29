package com.team.maplook;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class RegisterActivity extends Activity {

    private ImageView hp;
    private Bitmap head;//头像Bitmap
    private static String path="/sdcard/myHead/";//sd路径


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

        Bitmap bt = BitmapFactory.decodeFile(path + "head.jpg");//从Sd中找头像，转换成Bitmap
        if(bt!=null){
            @SuppressWarnings("deprecation")
            Drawable drawable = new BitmapDrawable(bt);//转换成drawable
            hp.setImageDrawable(drawable);
        }else{
            /**
             *	如果SD里面没有则需要从服务器取头像，取回来的头像再保存在SD中
             *
             */
        }

    }

    private void initView() {
        hp=(ImageView)findViewById(R.id.image_register_hp);
        Button btn_register_register = (Button)findViewById(R.id.btn_register_register);
        btn_register_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent();
                intent.setClass(RegisterActivity.this,ShowAccountActivity.class);
                startActivity(intent);
                RegisterActivity.this.finish();
            }
        });


        hp.setOnClickListener(new View.OnClickListener() {
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
        });



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
