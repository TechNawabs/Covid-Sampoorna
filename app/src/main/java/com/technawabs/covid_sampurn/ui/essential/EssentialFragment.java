package com.technawabs.covid_sampurn.ui.essential;

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
import com.technawabs.covid_sampurn.viewmodel.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;

public class EssentialFragment extends BaseFragment {

    @BindView(R.id.text_notifications)
    TextView textView;
    @Inject
    ViewModelFactory viewModelFactory;
    private EssentialViewModel essentialViewModel;

    @Override
    protected int layoutRes() {
        return R.layout.essential_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        essentialViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(EssentialViewModel.class);
        observableViewModel();
    }

    private void observableViewModel() {
        essentialViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
    }

}
