package com.technawabs.covid_sampurn.ui.main;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.airbnb.lottie.LottieAnimationView;
import com.gauravk.bubblenavigation.BubbleNavigationConstraintView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.technawabs.covid_sampurn.R;
import com.technawabs.covid_sampurn.base.BaseActivity;
import com.technawabs.covid_sampurn.ui.advice.AdviceFragment;
import com.technawabs.covid_sampurn.ui.daily.DailyListFragment;
import com.technawabs.covid_sampurn.ui.demographic.DemographicFragment;
import com.technawabs.covid_sampurn.ui.essential.EssentialFragment;
import com.technawabs.covid_sampurn.ui.helplines.HelplineFragment;
import com.technawabs.covid_sampurn.ui.national.NationalListFragment;
import com.technawabs.covid_sampurn.ui.national.adapter.GraphFragment;
import com.technawabs.covid_sampurn.ui.notifications.NotificationsFragment;
import com.technawabs.covid_sampurn.ui.raw.RawListFragment;
import com.technawabs.covid_sampurn.ui.state.StateListFragment;
import com.technawabs.covid_sampurn.ui.travel.TravelListFragment;

import static androidx.core.view.GravityCompat.START;

public class MainActivity extends BaseActivity{

    private FrameLayout topFrame;
    private BubbleNavigationConstraintView bottomFrame;
    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private NavController navController;
    private LottieAnimationView navButton;
    private BottomNavigationView bottomNavigationView;

    private ActionBar actionBar;

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        actionBar = getSupportActionBar();
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

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.nav_guidelines:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.nav_host_fragment, new AdviceFragment())
                                .commit();
                        drawer.close();
                        break;
                    case R.id.nav_essentials:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.nav_host_fragment, new EssentialFragment())
                                .commit();
                        drawer.close();
                        break;
                    case R.id.nav_helpful_stuff:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.nav_host_fragment, new TravelListFragment())
                                .commit();
                        drawer.close();
                        break;
                    case R.id.nav_states:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.nav_host_fragment, new StateListFragment())
                                .commit();
                        drawer.close();
                        break;
                    case R.id.nav_demographics:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.nav_host_fragment, new DemographicFragment())
                                .commit();
                        drawer.close();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });


        bottomFrame = findViewById(R.id.bottomFrame);
        //bottomFrame.setTypeface(Typeface.createFromAsset(getAssets(), "coffeesugar.ttf"));
        bottomFrame.setBadgeValue(2, "");

//        GraphFragment graphFragment = new GraphFragment();
//        GraphFragment.newInstance(0);
//        GraphFragment.newInstance(1);
//        GraphFragment.newInstance(2);
        bottomFrame.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {
                switch (position) {
                    case 0:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.nav_host_fragment, new NationalListFragment())
                                .commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.nav_host_fragment, new RawListFragment())
                                .commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.nav_host_fragment, new NotificationsFragment())
                                .commit();
                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.nav_host_fragment, new HelplineFragment())
                                .commit();
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
//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.mainFragment, new NationalListFragment())
//                .commit();
    }

    void initNavDrawer() {
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,
                R.id.navigation_helplines)
                .setDrawerLayout(drawer)
                .build();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public void onBackPressed(){

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
