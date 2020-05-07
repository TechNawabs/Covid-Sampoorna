package com.technawabs.covid_sampurn.ui.splash;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.airbnb.lottie.LottieAnimationView;
import com.technawabs.covid_sampurn.GraphSample;
import com.technawabs.covid_sampurn.R;
import com.technawabs.covid_sampurn.base.BaseActivity;

public class SplashScreen extends BaseActivity {
    TextView tv;
    Animation zoomOut;
    LottieAnimationView lav1,lav2,lav3;
    RelativeLayout myLayout;

    @Override
    protected int layoutRes() {
        return R.layout.activity_splash_screen;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash_screen);

        myLayout = findViewById(R.id.myLayout);
        lav1 = findViewById(R.id.animationView1);
        lav2 = findViewById(R.id.animationView2);
        lav3 = findViewById(R.id.animationView3);
        tv = findViewById(R.id.text1);
        zoomOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sliding_text);
        myLayout.setBackgroundColor(Color.WHITE);
        lav3.setAlpha(0f);
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
                lav3.setAlpha(1f);
                lav3.playAnimation();
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
                Intent i = new Intent(getApplicationContext(), GraphSample.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        },3*1000);

    }
}
