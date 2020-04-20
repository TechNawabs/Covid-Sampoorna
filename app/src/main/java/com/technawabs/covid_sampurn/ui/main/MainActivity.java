package com.technawabs.covid_sampurn.ui.main;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.technawabs.covid_sampurn.R;
import com.airbnb.lottie.LottieAnimationView;
import com.gauravk.bubblenavigation.BubbleNavigationConstraintView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;
import com.google.android.material.navigation.NavigationView;

import static androidx.core.view.GravityCompat.START;

public class MainActivity extends AppCompatActivity {
    FrameLayout topFrame;
    BubbleNavigationConstraintView bottomFrame;
    AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawer;
    NavigationView navigationView;
    NavController navController;
    LottieAnimationView navButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNavDrawer();
        initTopFrame();

        //Toggle navigation drawer by icon
        navButton = findViewById(R.id.navButton);
        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(START);
            }
        });

        bottomFrame = findViewById(R.id.bottomFrame);
        //bottomFrame.setTypeface(Typeface.createFromAsset(getAssets(), "coffeesugar.ttf"));
        bottomFrame.setBadgeValue(2, "");

        bottomFrame.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {
                switch (position) {
                    case 0:
                        Toast.makeText(getApplicationContext(), "This is Home", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "This is Dashboard", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "This is Covid Updates", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), "This is Helpline", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    void initTopFrame() {
        topFrame = findViewById(R.id.topFrame);
        AnimationDrawable animationDrawable = (AnimationDrawable) topFrame.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(2500);
        animationDrawable.start();
    }

    void initNavDrawer() {
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_guidelines, R.id.nav_essentials, R.id.nav_helpful_stuff, R.id.nav_states, R.id.nav_demographics)
                .setDrawerLayout(drawer)
                .build();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
       // NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public void onBackPressed(){

    }
}
