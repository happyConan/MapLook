package com.team.maplook;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.ArrayList;

public class LoadActivity extends Activity {







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        //设置背景图由深变浅效果
        Animation alpha_bg = AnimationUtils.loadAnimation(this,R.anim.alpha_bg);
        //设置logo图由浅变深效果
        Animation alpha_logo = AnimationUtils.loadAnimation(this,R.anim.alpha_logo);
        ImageView image_load_bg = (ImageView)findViewById(R.id.image_load_bg);
        ImageView image_load_logoch = (ImageView)findViewById(R.id.image_load_logoch);
        ImageView image_load_logoen = (ImageView)findViewById(R.id.image_load_logoen);
        image_load_bg.startAnimation(alpha_bg);
        image_load_logoch.startAnimation(alpha_logo);
        image_load_logoen.startAnimation(alpha_logo);
        //延迟两秒后执行run方法中的页面跳转
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoadActivity.this,LoginActivity.class);
                startActivity(intent);
                LoadActivity.this.finish();
            }
        },3900);
//        imageView.setAlpha(0.0f);
    }


}
