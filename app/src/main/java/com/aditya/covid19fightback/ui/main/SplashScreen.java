package com.aditya.covid19fightback.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.aditya.covid19fightback.R;
import com.aditya.covid19fightback.ui.main.MainActivity;

public class SplashScreen extends AppCompatActivity {
    TextView tv;
    Animation zoomOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        tv = (TextView)findViewById(R.id.text1);
        zoomOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sliding_text);
        tv.startAnimation(zoomOut);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        },6*1000);

    }
}
