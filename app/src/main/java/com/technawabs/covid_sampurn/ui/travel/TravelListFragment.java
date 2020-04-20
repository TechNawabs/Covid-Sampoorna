package com.technawabs.covid_sampurn.ui.travel;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.technawabs.covid_sampurn.R;
import com.technawabs.covid_sampurn.base.BaseFragment;
import com.technawabs.covid_sampurn.data.model.travel.TravelData;
import com.technawabs.covid_sampurn.viewmodel.ViewModelFactory;
import com.facebook.shimmer.ShimmerFrameLayout;

import javax.inject.Inject;

import butterknife.BindView;

public class TravelListFragment extends BaseFragment implements TravelSelectedListener {

    public String TAG = TravelListFragment.class.getSimpleName();

    @BindView(R.id.recyclerViewTravel)
    RecyclerView recyclerView;
    @BindView(R.id.errorTravel)
    TextView errorTextView;
    @BindView(R.id.travelShimmerFrameLayout)
    ShimmerFrameLayout shimmerFrameLayout;

    @Inject
    ViewModelFactory viewModelFactory;
    private TravelViewModel travelViewModel;

    @Override
    protected int layoutRes() {
        return R.layout.travel_list_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        travelViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(TravelViewModel.class);
        //        recyclerView.addItemDecoration(new DividerItemDecoration(getBaseActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(new TravelListAdapter(travelViewModel, this, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        observableViewModel();
    }

    @Override
    public void onTravelStatSelected(TravelData travelData) {
        Log.d(TAG,"onTravelStatSelected");
    }

    private void observableViewModel() {
        travelViewModel.getTravelStatResponse()
                .observe(getViewLifecycleOwner(), nationalTimeStats -> {
                    if(nationalTimeStats != null) {
                        recyclerView.setVisibility(View.VISIBLE);
                    }
                });

        travelViewModel.getRepoLoadError()
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
        travelViewModel.getLoading().observe(getViewLifecycleOwner(), isLoading -> {
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
