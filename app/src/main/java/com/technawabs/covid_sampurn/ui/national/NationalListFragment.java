package com.technawabs.covid_sampurn.ui.national;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.technawabs.covid_sampurn.R;
import com.technawabs.covid_sampurn.base.BaseFragment;
import com.technawabs.covid_sampurn.data.model.national.NationalTimeData;
import com.technawabs.covid_sampurn.ui.national.adapter.SectionsPagerAdapter;
import com.technawabs.covid_sampurn.viewmodel.ViewModelFactory;
import com.facebook.shimmer.ShimmerFrameLayout;

import javax.inject.Inject;

import butterknife.BindView;

public class NationalListFragment extends BaseFragment implements NationalSelectedListener {

    private static final String TAG = NationalListFragment.class.getSimpleName();

//    @BindView(R.id.recyclerViewNational) RecyclerView recyclerView;
//    @BindView(R.id.errorNational) TextView errorTextView;
//    @BindView(R.id.nationalShimmerFrameLayout) ShimmerFrameLayout shimmerFrameLayout;
    //    active
    @BindView(R.id.active_number)
    TextView activeNumberTextView;
    @BindView(R.id.active_growth_up_number)
    TextView activePercentUpTextView;
    @BindView(R.id.active_growth_down_number)
    TextView activePercentDownTextView;
    @BindView(R.id.active_growth_up)
    LinearLayout activeGrowthUpView;
    @BindView(R.id.active_growth_down)
    LinearLayout activeGrowthDownView;
    //    confirmed
    @BindView(R.id.confirmed_number)
    TextView confirmedNumberTextView;
    @BindView(R.id.confirmed_growth_up_number)
    TextView confirmedPercentUpTextView;
    @BindView(R.id.confirmed_growth_down_number)
    TextView confirmedPercentDownTextView;
    @BindView(R.id.confirmed_growth_up)
    LinearLayout confirmedGrowthUpView;
    @BindView(R.id.confirmed_growth_down)
    LinearLayout confirmedGrowthDownView;
    //    recovered
    @BindView(R.id.recovered_number)
    TextView recoveredNumberTextView;
    @BindView(R.id.recovered_growth_up_number)
    TextView recoveredPercentUpTextView;
    @BindView(R.id.recovered_growth_down_number)
    TextView recoveredPercentDownTextView;
    @BindView(R.id.recovered_growth_up)
    LinearLayout recoveredGrowthUpView;
    @BindView(R.id.recovered_growth_down)
    LinearLayout recoveredGrowthDownView;
    //    deceased
    @BindView(R.id.deceased_number)
    TextView deceasedNumberTextView;
    @BindView(R.id.deceased_growth_up_number)
    TextView deceasedPercentUpTextView;
    @BindView(R.id.deceased_growth_down_number)
    TextView deceasedPercentDownTextView;
    @BindView(R.id.deceased_growth_up)
    LinearLayout deceasedGrowthUpView;
    @BindView(R.id.deceased_growth_down)
    LinearLayout deceasedGrowthDownView;
    //    Tabs
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout graphViewTabs;

    private SectionsPagerAdapter sectionsPagerAdapter;

    @Inject
    ViewModelFactory viewModelFactory;
    private NationalViewModel nationalViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int layoutRes() {
        return R.layout.national_list_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        nationalViewModel = ViewModelProviders.of(this, viewModelFactory)
        .get(NationalViewModel.class);
        //        recyclerView.addItemDecoration(new DividerItemDecoration(getBaseActivity(), DividerItemDecoration.VERTICAL));
//        recyclerView.setAdapter(new NationalListAdapter(nationalViewModel, this, this));
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        sectionsPagerAdapter = new SectionsPagerAdapter(getContext(), getParentFragmentManager());
        Log.d(TAG, "Sre: "+sectionsPagerAdapter.getCount());
        viewPager.setAdapter(sectionsPagerAdapter);
        graphViewTabs.setupWithViewPager(viewPager);
        observableViewModel();
    }

    @Override
    public void onNationalStatSelected(NationalTimeData nationalTimeData) {
        Log.d(TAG,"onNationalStatSelected");
    }

    private void observableViewModel() {
        nationalViewModel.getNationalResponse()
        .observe(getViewLifecycleOwner(), nationalTimeStats -> {
            if(nationalTimeStats != null) {
//                recyclerView.setVisibility(View.VISIBLE);
            }
        });

        nationalViewModel.getRepoLoadError()
                .observe(getViewLifecycleOwner(), isError -> {
//                    if (isError) {
//                        errorTextView.setVisibility(View.VISIBLE);
//                        errorTextView.setText("Some Error occurred!");
//                        recyclerView.setItemViewCacheSize(View.GONE);
//                        shimmerFrameLayout.stopShimmer();
//                    } else {
//                        errorTextView.setVisibility(View.GONE);
//                        shimmerFrameLayout.startShimmer();
//                    }
                });
        nationalViewModel.getLoading().observe(getViewLifecycleOwner(), isLoading -> {
            if(isLoading != null) {
//                if(isLoading) {
//                    errorTextView.setVisibility(View.GONE);
//                    recyclerView.setVisibility(View.GONE);
//                    shimmerFrameLayout.startShimmer();
//                } else {
//                    shimmerFrameLayout.stopShimmer();
//                }
            }
        });
    }


}
