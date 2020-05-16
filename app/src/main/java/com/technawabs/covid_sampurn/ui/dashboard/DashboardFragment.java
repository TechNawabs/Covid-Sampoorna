package com.technawabs.covid_sampurn.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.technawabs.covid_sampurn.R;
import com.technawabs.covid_sampurn.base.BaseFragment;
import com.technawabs.covid_sampurn.ui.national.NationalViewModel;
import com.technawabs.covid_sampurn.viewmodel.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;

public class DashboardFragment extends BaseFragment {

    private static String TAG = DashboardFragment.class.getSimpleName();
    @BindView(R.id.dashboard_text)
    TextView textView;
    @Inject
    ViewModelFactory viewModelFactory;
    DashboardViewModel dashboardViewModel;

    @Override
    protected int layoutRes() {
        return R.layout.dashboard_list_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        dashboardViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(DashboardViewModel.class);
        observableViewModel();
    }

    private void observableViewModel() {
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
    }

}
