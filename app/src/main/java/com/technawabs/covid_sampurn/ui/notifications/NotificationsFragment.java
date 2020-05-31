package com.technawabs.covid_sampurn.ui.notifications;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.airbnb.lottie.LottieAnimationView;
import com.technawabs.covid_sampurn.R;
import com.technawabs.covid_sampurn.base.BaseFragment;
import com.technawabs.covid_sampurn.ui.raw.RawViewModel;
import com.technawabs.covid_sampurn.viewmodel.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;

public class NotificationsFragment extends BaseFragment {

    @BindView(R.id.playStore)
    ImageView playStore;
    @BindView(R.id.appInstalled)
    ImageView appInstalled;
    @BindView(R.id.webPage)
    LottieAnimationView webPage;
    @BindView(R.id.facebookPage)
    LottieAnimationView facebookPage;
    @BindView(R.id.twitterPage)
    LottieAnimationView twitterPage;
    @BindView(R.id.aarogyaSetuCard)
    CardView aarogyaCard;
    @BindView(R.id.downloadOrInstalled)
    TextView downldOrInst;

    Animation riseUp;

    @Inject
    ViewModelFactory viewModelFactory;
    private NotificationsViewModel notificationsViewModel = new NotificationsViewModel();

    private final String aarogayaAppPackage = "nic.goi.aarogyasetu";
    private PackageManager packageManager;
    private boolean isAarogayaAppInstalled = false;

    @Override
    protected int layoutRes() {
        return R.layout.notifications_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        riseUp = AnimationUtils.loadAnimation(getContext(), R.anim.rise_up);
        aarogyaCard.startAnimation(riseUp);
        notificationsViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(NotificationsViewModel.class);
        observableViewModel();
    }


    private void observableViewModel() {
        //        check app store
        try {
            packageManager = getContext().getPackageManager();
            isAarogayaAppInstalled = isPackageInstalled(aarogayaAppPackage, packageManager);
        } catch (Exception ex) {

        }
        if (isAarogayaAppInstalled) {
            appInstalled.setVisibility(View.VISIBLE);
            playStore.setVisibility(View.GONE);
            downldOrInst.setText(R.string.installed);
            downldOrInst.setTextColor(Color.BLUE);
        } else {
            appInstalled.setVisibility(View.GONE);
            playStore.setVisibility(View.VISIBLE);
            downldOrInst.setText(R.string.download);
            downldOrInst.setTextColor(Color.BLUE);
        }
        notificationsViewModel.getPlayStoreURL().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (!isAarogayaAppInstalled) {
                    aarogyaCard.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            urlOpenIntent(s,"Install Aarogya Setu From Play Store");
                        }
                    });
                }
            }
        });
        notificationsViewModel.getFacebookPageURL().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                facebookPage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        urlOpenIntent(s,"Govt of India's Facebook Page");
                    }
                });
            }
        });
        notificationsViewModel.getTwitterPageURL().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                twitterPage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        urlOpenIntent(s,"Govt of India's Twitter Page");
                    }
                });
            }
        });
        notificationsViewModel.getWebPageURL().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                webPage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        urlOpenIntent(s,"Govt of India's Website");
                    }
                });
            }
        });
    }

    public void urlOpenIntent(@NonNull String url, @NonNull String title) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        Intent chooser = Intent.createChooser(intent, title);
        startActivity(chooser);
    }

    private boolean isPackageInstalled(String packageName, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

}
