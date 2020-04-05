package com.aditya.covid19fightback.ui.state;

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
import com.aditya.covid19fightback.data.model.state.StateData;
import com.aditya.covid19fightback.ui.national.NationalListAdapter;
import com.aditya.covid19fightback.ui.national.NationalViewModel;
import com.aditya.covid19fightback.viewmodel.ViewModelFactory;
import com.facebook.shimmer.ShimmerFrameLayout;

import javax.inject.Inject;

import butterknife.BindView;

public class StateListFragment extends BaseFragment implements StateSelectedListener {

    private static final String TAG = StateListFragment.class.getSimpleName();

    @BindView(R.id.recyclerViewState)
    RecyclerView recyclerView;
    @BindView(R.id.errorState)
    TextView errorTextView;
    @BindView(R.id.stateShimmerFrameLayout)
    ShimmerFrameLayout shimmerFrameLayout;
    @Inject
    ViewModelFactory viewModelFactory;
    private StateViewModel stateViewModel;

    @Override
    protected int layoutRes() {
        return R.layout.state_list_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        stateViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(StateViewModel.class);
        //        recyclerView.addItemDecoration(new DividerItemDecoration(getBaseActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(new StateListAdapter(stateViewModel, this, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        observableViewModel();
    }

    @Override
    public void onStateStatSelected(StateData stateData) {
        Log.d(TAG,"onStateStatSelected");
    }

    private void observableViewModel() {
        stateViewModel.getStateResponse()
                .observe(getViewLifecycleOwner(), nationalTimeStats -> {
                    if(nationalTimeStats != null) {
                        recyclerView.setVisibility(View.VISIBLE);
                    }
                });

        stateViewModel.getRepoLoadError()
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
        stateViewModel.getLoading().observe(getViewLifecycleOwner(), isLoading -> {
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
