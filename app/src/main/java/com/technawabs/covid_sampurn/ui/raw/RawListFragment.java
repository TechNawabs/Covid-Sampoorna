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

    @Inject
    ViewModelFactory viewModelFactory;
    private RawViewModel rawViewModel;

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

}
