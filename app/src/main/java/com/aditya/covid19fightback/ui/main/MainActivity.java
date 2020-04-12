package com.aditya.covid19fightback.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.aditya.covid19fightback.R;
import com.aditya.covid19fightback.base.BaseActivity;
import com.aditya.covid19fightback.ui.daily.DailyListFragment;
import com.aditya.covid19fightback.ui.national.NationalListFragment;
import com.aditya.covid19fightback.ui.raw.RawListFragment;
import com.aditya.covid19fightback.ui.state.StateListFragment;
import com.aditya.covid19fightback.ui.travel.TravelListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    private static String TAG = MainActivity.class.getSimpleName();
    Fragment dashboard = new RawListFragment();
    Fragment health = new DailyListFragment();
    Fragment helpline = new NationalListFragment();
    Fragment active = dashboard;
    final FragmentManager fragmentManager = getSupportFragmentManager();
    @BindView(R.id.bottomActionBar) BottomNavigationView bottomNavigationView;

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null) {
            if(getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.screenContainer, new DailyListFragment()).commit();
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.screenContainer, new NationalListFragment()).commit();
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.screenContainer, new RawListFragment()).commit();
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.screenContainer, new StateListFragment()).commit();
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.screenContainer, new TravelListFragment()).commit();

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.nav_dashboard:
                            fragmentManager.beginTransaction().hide(active).show(dashboard).commit();
                            return true;
                        case R.id.nav_health:
                            fragmentManager.beginTransaction().hide(active).show(health).commit();
                            return true;
                        case R.id.nav_helpline:
                            fragmentManager.beginTransaction().hide(active).show(helpline).commit();
                            return true;
                    }
                    return false;
                }
            });

            fragmentManager.beginTransaction().add(R.id.screenContainer, helpline, "3")
                    .hide(helpline).commit();
            fragmentManager.beginTransaction().add(R.id.screenContainer, health, "2")
                    .hide(health).commit();
            fragmentManager.beginTransaction().add(R.id.screenContainer, dashboard, "1")
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
//        if (id == R.id.actio)
        return super.onOptionsItemSelected(item);
    }
}
