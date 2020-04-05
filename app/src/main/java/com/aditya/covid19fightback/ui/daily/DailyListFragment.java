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
        recyclerView.addItemDecoration(new DividerItemDecoration(getBaseActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(new DailyListAdapter(dailyViewModel, this, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        observableViewModel();
    }

    @Override
    public void onDailyStatSelected(DailyStates dailyStat) {

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
                    if (isError != null) {
                        errorTextView.setVisibility(View.VISIBLE);
                        recyclerView.setItemViewCacheSize(View.GONE);
                        errorTextView.setVisibility(View.GONE);
                    } else {
                        errorTextView.setText(View.GONE);
                    }
                });
        dailyViewModel.getLoading().observe(getViewLifecycleOwner(), isLoading -> {
            if(isLoading != null) {
                shimmerFrameLayout.setVisibility(isLoading?View.VISIBLE:View.GONE);
                if(isLoading) {
                    errorTextView.setText(View.GONE);
                    recyclerView.setItemViewCacheSize(View.GONE);
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
