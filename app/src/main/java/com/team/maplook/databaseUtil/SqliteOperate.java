package com.team.maplook.databaseUtil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/7/31.
 */
public class SqliteOperate {

    public static String mAccount;

    public static SQLiteDatabase createDatabase(Context context)
    {
        StuDBHelper dbHelper = new StuDBHelper(context,"stu_db",null,1);
        SQLiteDatabase db =dbHelper.getReadableDatabase();

        return db;
    }


    public static int getCount(Context context)
    {
        StuDBHelper dbHelper = new StuDBHelper(context,"stu_db",null,1);
        SQLiteDatabase db =dbHelper.getReadableDatabase();
        Cursor c=db.rawQuery("select * from info",null);
        return c.getCount();
    }


    public static String[] QueryDatabase(Context context,String account)
    {
        String[] s=new String[4];
        StuDBHelper dbHelper = new StuDBHelper(context,"stu_db",null,1);
        SQLiteDatabase db =dbHelper.getReadableDatabase();
        Cursor c=db.rawQuery("select * from info where account="+account,null);
        while(c.moveToNext())
        {
            s[0]=c.getString(c.getColumnIndex("name"));
            s[1]=c.getString(c.getColumnIndex("sex"));
            s[2]=c.getString(c.getColumnIndex("selfDes"));
            s[3]=c.getString(c.getColumnIndex("password"));
        }

        return s;
    }

    public static Bitmap QueryBitmap(Context context,String account)
    {
        Bitmap bmp=null;
        StuDBHelper dbHelper = new StuDBHelper(context,"stu_db",null,1);
        SQLiteDatabase db =dbHelper.getReadableDatabase();
        Cursor c=db.rawQuery("select * from info where account="+account,null);
        while(c.moveToNext())
        {
           bmp=cursorToBmp(c,c.getColumnIndex("img"));
        }
        return bmp;
    }



    public static int QueryDatabase(Context context,String account,String birth,String farName)
    {
        StuDBHelper dbHelper = new StuDBHelper(context,"stu_db",null,1);
        SQLiteDatabase db =dbHelper.getReadableDatabase();
        Cursor c=db.rawQuery("select * from info where account="+account,null);
        if(c.getCount()==0)
            return -1;//数据库中不存在此账户
        while(c.moveToNext())
        {
            String fName=c.getString(c.getColumnIndex("pName"));
            String birthday=c.getString(c.getColumnIndex("birth"));
            if(fName.equals(farName)&&birth.equals(birthday))
               return 1;//密保问题回答正确
            else
                return 2;//回答错误
        }

        return -1;
    }




    public static int QueryDatabase(Context context,String account,String pwd)
    {
        StuDBHelper dbHelper = new StuDBHelper(context,"stu_db",null,1);
        SQLiteDatabase db =dbHelper.getReadableDatabase();
        Cursor c=db.rawQuery("select * from info where account="+account,null);

        if(c.getCount()==0)
            return 0;//账号不存在的情况

        while(c.moveToNext())
        {
            String password=c.getString(c.getColumnIndex("password"));
            if(password.equals(pwd))
               return 1;//密码输入正确的情况
            else
                return 2;//密码输入错误地情况
        }
        return 0;
    }





    public static void InsertDatabase(Context context,String account,String name,String sex,String birth,String pName,String password,Bitmap bmp)
    {
        StuDBHelper dbHelper = new StuDBHelper(context,"stu_db",null,1);
//得到一个可写的数据库
        SQLiteDatabase db =dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("sex", sex);
        values.put("birth",birth);
        values.put("pName",pName);
        values.put("password",password);
        values.put("img", bmpToByteArray(bmp));
        values.put("account",account);
        db.insert("info", null, values);
        db.close();
    }

    public static void updateDatabase(String account,Context context,String nickname,String selfDes,String password)
    {
        StuDBHelper dbHelper = new StuDBHelper(context,"stu_db",null,1);
//得到一个可写的数据库
        SQLiteDatabase db =dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",nickname);
        values.put("selfDes",selfDes);
        values.put("password",password);

        db.update("info",values,"account=?",new String[]{account});
        db.close();

    }


    //修改密码
    public static void updateDatabase(String account,Context context,String password)
    {
        StuDBHelper dbHelper = new StuDBHelper(context,"stu_db",null,1);
//得到一个可写的数据库
        SQLiteDatabase db =dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("password",password);
        db.update("info",values,"account=?",new String[]{account});
        db.close();

    }










    public static void updateDatabase(Context context,String account,Bitmap bmp)
    {
        StuDBHelper dbHelper = new StuDBHelper(context,"stu_db",null,1);
//得到一个可写的数据库
        SQLiteDatabase db =dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("img", bmpToByteArray(bmp));
        db.update("info",values,"account=?",new String[]{account});
        db.close();
    }




    public static Bitmap cursorToBmp(Cursor c, int columnIndex) {

        byte[] data = c.getBlob(columnIndex);
        try {
            return BitmapFactory.decodeByteArray(data, 0, data.length);
        } catch (Exception e) {
            return null;
        }
    }




    public static byte[] bmpToByteArray(Bitmap bmp) {
        // Default size is 32 bytes
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            bmp.compress(Bitmap.CompressFormat.PNG, 100, bos);
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bos.toByteArray();
    }


}
