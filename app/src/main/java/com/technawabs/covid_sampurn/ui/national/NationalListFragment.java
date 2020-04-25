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

import java.util.Collections;

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
                if (nationalTimeStats.getNationalTimeDataList() != null
                        && nationalTimeStats.getNationalTimeDataList().size() > 0) {
                    NationalTimeData lastTimeData = nationalTimeStats.getNationalTimeDataList()
                            .get(nationalTimeStats.getNationalTimeDataList().size()-1);
                    NationalTimeData secondLastTimeData = nationalTimeStats.getNationalTimeDataList()
                            .get(nationalTimeStats.getNationalTimeDataList().size()-2);
                    confirmedNumberTextView.setText(lastTimeData.totalConfirmed);
                    deceasedNumberTextView.setText(lastTimeData.totalDeceased);
                    recoveredNumberTextView.setText(lastTimeData.totalRecovered);
                    int activeNumber = Integer.parseInt(lastTimeData.totalConfirmed)
                            - Integer.parseInt(lastTimeData.totalDeceased)
                            - Integer.parseInt(lastTimeData.totalRecovered);
                    activeNumberTextView.setText(activeNumber+ "");
//                  compared confirmed
                    int compareConfirmed = Integer.parseInt(lastTimeData.totalConfirmed)
                            - Integer.parseInt(secondLastTimeData.totalConfirmed);
                    if (compareConfirmed < 0) {
                        confirmedGrowthDownView.setVisibility(View.VISIBLE);
                        confirmedGrowthUpView.setVisibility(View.INVISIBLE);
                        confirmedPercentDownTextView.setText(compareConfirmed+ "");
                    } else {
                        confirmedGrowthDownView.setVisibility(View.INVISIBLE);
                        confirmedGrowthUpView.setVisibility(View.VISIBLE);
                        confirmedPercentUpTextView.setText(compareConfirmed+ "");
                    }
                    //  compared deceased
                    int compareDeceased = Integer.parseInt(lastTimeData.totalDeceased)
                            - Integer.parseInt(secondLastTimeData.totalDeceased);
                    if (compareDeceased < 0) {
                        deceasedGrowthDownView.setVisibility(View.VISIBLE);
                        deceasedGrowthUpView.setVisibility(View.INVISIBLE);
                        deceasedPercentDownTextView.setText(compareDeceased+ "");
                    } else {
                        deceasedGrowthDownView.setVisibility(View.INVISIBLE);
                        deceasedGrowthUpView.setVisibility(View.VISIBLE);
                        deceasedPercentUpTextView.setText(compareDeceased+ "");
                    }
                    //  compared recovered
                    int compareRecovered = Integer.parseInt(lastTimeData.totalRecovered)
                            - Integer.parseInt(secondLastTimeData.totalRecovered);
                    if (compareRecovered < 0) {
                        recoveredGrowthDownView.setVisibility(View.VISIBLE);
                        recoveredGrowthUpView.setVisibility(View.INVISIBLE);
                        recoveredPercentDownTextView.setText(compareRecovered+ "");
                    } else {
                        recoveredGrowthDownView.setVisibility(View.INVISIBLE);
                        recoveredGrowthUpView.setVisibility(View.VISIBLE);
                        recoveredPercentUpTextView.setText(compareRecovered+ "");
                    }
                    //  compared active
                    int secondActiveNumber = Integer.parseInt(lastTimeData.totalConfirmed)
                            - Integer.parseInt(lastTimeData.totalDeceased)
                            - Integer.parseInt(lastTimeData.totalRecovered);
                    int compareActive = activeNumber - secondActiveNumber;
                    if (compareActive < 0) {
                        activeGrowthDownView.setVisibility(View.VISIBLE);
                        activeGrowthUpView.setVisibility(View.INVISIBLE);
                        activePercentDownTextView.setText(compareActive+ "");
                    } else {
                        activeGrowthDownView.setVisibility(View.INVISIBLE);
                        activeGrowthUpView.setVisibility(View.VISIBLE);
                        activePercentUpTextView.setText(compareActive+ "");
                    }
                }
            }
        });

        nationalViewModel.getRepoLoadError()
                .observe(getViewLifecycleOwner(), isError -> {
                    if (isError) {
//                        errorTextView.setVisibility(View.VISIBLE);
//                        errorTextView.setText("Some Error occurred!");
//                        recyclerView.setItemViewCacheSize(View.GONE);
//                        shimmerFrameLayout.stopShimmer();
                    } else {
//                        errorTextView.setVisibility(View.GONE);
//                        shimmerFrameLayout.startShimmer();
                    }
                });
        nationalViewModel.getLoading().observe(getViewLifecycleOwner(), isLoading -> {
            if(isLoading != null) {
                if(isLoading) {
//                    errorTextView.setVisibility(View.GONE);
//                    recyclerView.setVisibility(View.GONE);
//                    shimmerFrameLayout.startShimmer();
                } else {
//                    shimmerFrameLayout.stopShimmer();
                }
            }
        });
    }


}