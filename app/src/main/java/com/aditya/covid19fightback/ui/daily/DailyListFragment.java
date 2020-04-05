package com.aditya.covid19fightback.ui.daily;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.covid19fightback.R;
import com.aditya.covid19fightback.base.BaseFragment;
import com.aditya.covid19fightback.data.model.daily.DailyData;
import com.aditya.covid19fightback.data.model.daily.DailyStates;
import com.aditya.covid19fightback.viewmodel.ViewModelFactory;
import com.facebook.shimmer.ShimmerFrameLayout;

import javax.inject.Inject;

import butterknife.BindView;

public class DailyListFragment extends BaseFragment implements DailySelectedListener {

    private static final String TAG = DailyListFragment.class.getSimpleName();

    @BindView(R.id.recyclerViewDaily) RecyclerView recyclerView;
    @BindView(R.id.errorDaily) TextView errorTextView;
    @BindView(R.id.dailyShimmerFrameLayout) ShimmerFrameLayout shimmerFrameLayout;

    @Inject
    ViewModelFactory viewModelFactory;
    private DailyViewModel dailyViewModel;

    @Override
    protected int layoutRes() {
        return R.layout.daily_list_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        dailyViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(DailyViewModel.class);
//        recyclerView.addItemDecoration(new DividerItemDecoration(getBaseActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(new DailyListAdapter(dailyViewModel, this, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        observableViewModel();
    }

    @Override
    public void onDailyStatSelected(DailyData dailyStat) {
        Log.d(TAG,"onDailyStatSelected");
    }

    private void observableViewModel() {
        dailyViewModel.getDailyResponse()
                .observe(getViewLifecycleOwner(), dailyStates -> {
                    if (dailyStates != null) {
                        recyclerView.setVisibility(View.VISIBLE);
                    }
                });
        dailyViewModel.getError()
                .observe(getViewLifecycleOwner(), isError -> {
                    if (isError) {
                        errorTextView.setVisibility(View.VISIBLE);
                        errorTextView.setText("Some Error occurred!");
                        recyclerView.setItemViewCacheSize(View.GONE);
                        shimmerFrameLayout.stopShimmer();
//                        shimmerFrameLayout.setVisibility(View.GONE);
                    } else {
                        errorTextView.setVisibility(View.GONE);
                        shimmerFrameLayout.startShimmer();
                    }
                });
        dailyViewModel.getLoading().observe(getViewLifecycleOwner(), isLoading -> {
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

        @Override
    public void onResume() {
        super.onResume();
        shimmerFrameLayout.startShimmer();
    }

    @Override
    public void onStop() {
        shimmerFrameLayout.startShimmer();
        super.onStop();
    }

}
