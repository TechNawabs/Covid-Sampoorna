package com.aditya.covid19fightback.ui.main;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aditya.covid19fightback.Dashboard;
import com.aditya.covid19fightback.R;
import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {
    TextView tv;
    Animation zoomOut;
    LottieAnimationView lav1,lav2;
    RelativeLayout myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        myLayout = (RelativeLayout)findViewById(R.id.myLayout);
        lav1 =(LottieAnimationView)findViewById(R.id.animationView1);
        lav2 =(LottieAnimationView)findViewById(R.id.animationView2);
        tv = (TextView)findViewById(R.id.text1);
        zoomOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sliding_text);
        myLayout.setBackgroundColor(Color.WHITE);
        lav2.setAlpha(0f);
        tv.setAlpha(0);
        lav1.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                lav1.setAlpha(0f);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    }
                },3*1000);
                myLayout.setBackgroundResource(R.drawable.gradient);
                lav2.setAlpha(1f);
                lav2.playAnimation();
                tv.setAlpha(1);
                tv.startAnimation(zoomOut);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        },9*1000);

    }
}
