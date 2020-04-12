package com.aditya.covid19fightback;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.wwdablu.soumya.lottiebottomnav.FontBuilder;
import com.wwdablu.soumya.lottiebottomnav.FontItem;
import com.wwdablu.soumya.lottiebottomnav.ILottieBottomNavCallback;
import com.wwdablu.soumya.lottiebottomnav.LottieBottomNav;
import com.wwdablu.soumya.lottiebottomnav.MenuItem;
import com.wwdablu.soumya.lottiebottomnav.MenuItemBuilder;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity implements ILottieBottomNavCallback {
    LottieBottomNav bottomNav;
    ArrayList<MenuItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        FrameLayout topFrame = (FrameLayout)findViewById(R.id.topFrame);
        AnimationDrawable animationDrawable = (AnimationDrawable)topFrame.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2500);
        animationDrawable.start();

        bottomNav = findViewById(R.id.bottom_nav);

        FontItem fontItem = FontBuilder.create("Home")
                .selectedTextColor(Color.BLACK)
                .unSelectedTextColor(Color.GRAY)
                .selectedTextSize(16) //SP
                .unSelectedTextSize(12) //SP
                .setTypeface(Typeface.createFromAsset(getAssets(), "coffeesugar.ttf"))
                .build();

        SpannableString spannableString1 = new SpannableString("Home");
        spannableString1.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        fontItem = FontBuilder.create(fontItem).setTitle(spannableString1).build();
        MenuItem item1 = MenuItemBuilder.create("home_unselected.json", MenuItem.Source.Assets, fontItem, "home")
                .unSelectedLottieName("home.json")
                .selectedLottieName("home.json")
                .loop(true)
                .build();

        SpannableString spannableString2 = new SpannableString("Dashboard");
        spannableString2.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        fontItem = FontBuilder.create(fontItem).setTitle(spannableString2).build();
        MenuItem item2 = MenuItemBuilder.createFrom(item1, fontItem)
                .selectedLottieName("statistics.json")
                .unSelectedLottieName("statistics_unselected.json")
                .loop(true)
                .build();

        SpannableString spannableString3 = new SpannableString("Helplines");
        spannableString3.setSpan(new ForegroundColorSpan(Color.GREEN), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        fontItem = FontBuilder.create(fontItem).setTitle(spannableString3).build();
        MenuItem item3 = MenuItemBuilder.createFrom(item1, fontItem)
                .selectedLottieName("phone.json")
                .unSelectedLottieName("phone_unselected.json")
                .loop(true)
                .build();

        SpannableString spannableString4 = new SpannableString("Settings");
        spannableString4.setSpan(new ForegroundColorSpan(Color.YELLOW), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        fontItem = FontBuilder.create(fontItem).setTitle(spannableString4).build();
        MenuItem item4 = MenuItemBuilder.createFrom(item1, fontItem)
                .selectedLottieName("settings.json")
                .unSelectedLottieName("settings_unselected.json")
                .loop(true)
                .build();

        list = new ArrayList<>(4);
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);

        bottomNav.setCallback(this);
        bottomNav.setMenuItemList(list);
    }

    @Override
    public void onMenuSelected(int oldIndex, int newIndex, MenuItem menuItem) {

    }

    @Override
    public void onAnimationStart(int index, MenuItem menuItem) {

    }

    @Override
    public void onAnimationEnd(int index, MenuItem menuItem) {

    }

    @Override
    public void onAnimationCancel(int index, MenuItem menuItem) {

    }
}
