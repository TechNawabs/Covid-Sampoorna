package com.technawabs.covid_sampurn.ui.raw;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.technawabs.covid_sampurn.R;
import com.technawabs.covid_sampurn.base.BaseFragment;
import com.technawabs.covid_sampurn.data.model.raw.RawData;
import com.technawabs.covid_sampurn.viewmodel.ViewModelFactory;
import com.facebook.shimmer.ShimmerFrameLayout;

import javax.inject.Inject;

import butterknife.BindView;

public class RawListFragment extends BaseFragment implements RawSelectedListener {

    private static final String TAG = RawListFragment.class.getSimpleName();

    @BindView(R.id.recyclerViewRaw)
    RecyclerView recyclerView;
    @BindView(R.id.errorRaw)
    TextView errorTextView;
    @BindView(R.id.rawShimmerFrameLayout)
    ShimmerFrameLayout shimmerFrameLayout;

    @BindView(R.id.playStore)
    ImageView playStore;
    @BindView(R.id.appInstalled)
    ImageView appInstalled;
    @BindView(R.id.webPage)
    ImageView webPage;
    @BindView(R.id.facebookPage)
    ImageView facebookPage;
    @BindView(R.id.twitterPage)
    ImageView twitterPage;
    @BindView(R.id.aarogyaSetuCard)
    CardView aarogyaCard;

    @Inject
    ViewModelFactory viewModelFactory;
    private RawViewModel rawViewModel;

    private String aarogayaAppPackage = "nic.goi.aarogyasetu";
    private PackageManager packageManager;
    private boolean isAarogayaAppInstalled = false;

    @Override
    protected int layoutRes() {
        return R.layout.raw_list_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rawViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(RawViewModel.class);
        //        recyclerView.addItemDecoration(new DividerItemDecoration(getBaseActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(new RawListAdapter(rawViewModel, this, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        observableViewModel();
    }

    @Override
    public void onRawStatSelected(RawData rawData) {
        Log.d(TAG,"onRawStatSelected");
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
        } else {
            appInstalled.setVisibility(View.GONE);
            playStore.setVisibility(View.VISIBLE);
        }
        rawViewModel.getPlayStoreURL().observe(getViewLifecycleOwner(), new Observer<String>() {
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
        rawViewModel.getFacebookPageURL().observe(getViewLifecycleOwner(), new Observer<String>() {
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
        rawViewModel.getTwitterPageURL().observe(getViewLifecycleOwner(), new Observer<String>() {
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
        rawViewModel.getWebPageURL().observe(getViewLifecycleOwner(), new Observer<String>() {
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
//      response traveller
        rawViewModel.getRawResponse()
                .observe(getViewLifecycleOwner(), nationalTimeStats -> {
                    if(nationalTimeStats != null) {
                        recyclerView.setVisibility(View.VISIBLE);
                    }
                });

        rawViewModel.getRepoLoadError()
                .observe(getViewLifecycleOwner(), isError -> {
                    if (isError) {
                        errorTextView.setVisibility(View.VISIBLE);
                        errorTextView.setText("Some Error occurred!");
                        recyclerView.setItemViewCacheSize(View.GONE);
                        shimmerFrameLayout.stopShimmer();
                    } else {
                        errorTextView.setVisibility(View.GONE);
                        shimmerFrameLayout.startShimmer();
                    }
                });
        rawViewModel.getLoading().observe(getViewLifecycleOwner(), isLoading -> {
            if(isLoading != null) {
                if(isLoading) {
                    errorTextView.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.GONE);
                    shimmerFrameLayout.startShimmer();
                } else {
                    shimmerFrameLayout.stopShimmer();
                }
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
