package com.cz10000.lvtaxi.splash;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.cz10000.lvtaxi.R;
import com.cz10000.lvtaxi.main.Main2Activity;

/**
 * 欢迎页
 *
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            AnimatedVectorDrawable anim1 = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.anim);
            ImageView logo = findViewById(R.id.logo) ;
            logo.setImageDrawable(anim1);
            anim1.start();

        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,Main2Activity.class));
                finish();
            }
        },3000) ;

//        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
//            AnimatedVectorDrawable anim1 = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.anim1);
//            ImageView logo = findViewById(R.id.logo) ;
//            logo.setImageDrawable(anim1);
//            anim1.start();
//            AnimatedVectorDrawable anim2 = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.anim2);
//            ImageView logo1 = findViewById(R.id.logo1) ;
//            logo1.setImageDrawable(anim2);
//            anim2.start();
//            AnimatedVectorDrawable anim3 = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.anim3);
//            ImageView logo2 = findViewById(R.id.logo2) ;
//            logo2.setImageDrawable(anim3);
//            anim3.start();
//
//        }


    }



}
