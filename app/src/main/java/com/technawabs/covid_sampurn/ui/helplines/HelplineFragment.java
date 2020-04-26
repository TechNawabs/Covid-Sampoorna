package com.technawabs.covid_sampurn.ui.helplines;

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

public class HelplineFragment extends Fragment {

    private HelplineViewModel helplineViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        helplineViewModel =
                ViewModelProviders.of(this).get(HelplineViewModel.class);
        View root = inflater.inflate(R.layout.helpline_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        helplineViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
