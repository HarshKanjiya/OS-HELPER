package com.example.oshelper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class splash_screen extends AppCompatActivity {
    LottieAnimationView animationView;
    TextView t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        animationView=findViewById(R.id.animation_view);


        animationView.playAnimation();
        Intent intent= new Intent(splash_screen.this,MainActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        },3000);

        Animation fade_in = AnimationUtils.loadAnimation(this,R.anim.fade_in);

        t1.startAnimation(fade_in);
        t2.startAnimation(fade_in);
        t3.startAnimation(fade_in);
        t4.startAnimation(fade_in);

    }
}