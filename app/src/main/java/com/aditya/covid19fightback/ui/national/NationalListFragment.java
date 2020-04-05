package com.aditya.covid19fightback.ui.national;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.covid19fightback.R;
import com.aditya.covid19fightback.base.BaseFragment;
import com.aditya.covid19fightback.data.model.national.NationalTimeData;
import com.aditya.covid19fightback.viewmodel.ViewModelFactory;
import com.facebook.shimmer.ShimmerFrameLayout;

import javax.inject.Inject;

import butterknife.BindView;

public class NationalListFragment extends BaseFragment implements NationalSelectedListener {

    private static final String TAG = NationalListFragment.class.getSimpleName();

    @BindView(R.id.recyclerViewNational) RecyclerView recyclerView;
    @BindView(R.id.errorNational) TextView errorTextView;
    @BindView(R.id.nationalShimmerFrameLayout) ShimmerFrameLayout shimmerFrameLayout;

    @Inject
    ViewModelFactory viewModelFactory;
    private NationalViewModel nationalViewModel;

    @Override
    protected int layoutRes() {
        return R.layout.national_list_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        nationalViewModel = ViewModelProviders.of(this, viewModelFactory)
        .get(NationalViewModel.class);
        //        recyclerView.addItemDecoration(new DividerItemDecoration(getBaseActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(new NationalListAdapter(nationalViewModel, this, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
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
                recyclerView.setVisibility(View.VISIBLE);
            }
        });

        nationalViewModel.getRepoLoadError()
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
        nationalViewModel.getLoading().observe(getViewLifecycleOwner(), isLoading -> {
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
