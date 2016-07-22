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
        Animation alpha = AnimationUtils.loadAnimation(this,R.anim.alpha);
        //设置文字图由浅变深效果
        Animation alpha2 = AnimationUtils.loadAnimation(this,R.anim.alpha_word);
        ImageView bg = (ImageView)findViewById(R.id.load_image);
        ImageView chword = (ImageView)findViewById(R.id.load_word_ch);
        ImageView enword = (ImageView)findViewById(R.id.load_word_en);
        bg.startAnimation(alpha);
        chword.startAnimation(alpha2);
        enword.startAnimation(alpha2);
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
