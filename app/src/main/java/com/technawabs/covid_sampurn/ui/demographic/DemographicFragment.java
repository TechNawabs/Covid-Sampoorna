package com.technawabs.covid_sampurn.ui.demographic;

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

public class DemographicFragment extends Fragment {

    private DemographicViewModel demographicViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        demographicViewModel =
                ViewModelProviders.of(this).get(DemographicViewModel.class);
        View root = inflater.inflate(R.layout.demographic_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        demographicViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
