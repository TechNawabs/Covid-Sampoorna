package com.technawabs.covid_sampurn.ui.helplines;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.technawabs.covid_sampurn.R;
import com.technawabs.covid_sampurn.base.BaseFragment;
import com.technawabs.covid_sampurn.data.model.helpline.HelplineData;
import com.technawabs.covid_sampurn.data.model.helpline.StateHelpline;
import com.technawabs.covid_sampurn.viewmodel.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;

public class HelplineFragment extends BaseFragment implements HelplineSelectedListener {

    private static final String TAG = HelplineFragment.class.getSimpleName();

    @BindView(R.id.recyclerViewHelpline)
    RecyclerView stateHelplinesRecycler;

    @Inject
    ViewModelFactory viewModelFactory;
    private HelplineViewModel helplineViewModel;
    private HelplineData helplineData;

    @Override
    protected int layoutRes() {
        return R.layout.helpline_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        helplineViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(HelplineViewModel.class);
        observableViewModel();
        stateHelplinesRecycler.setAdapter(new HelplineListAdapter(helplineData.getHelplineDataList(),
                this));
        stateHelplinesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void observableViewModel() {
//        helplineViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                textView.setText(s);
//            }
//        });
        helplineViewModel.getHelplineResponse()
                .observe(getViewLifecycleOwner(), helplineData -> {
                    if (helplineData != null) {
                        Log.d(TAG,helplineData.toString());
                    }
                });
        helplineViewModel.getError()
                .observe(getViewLifecycleOwner(), isError -> {
                    if (isError) {
//                        textView.setText("Some Error occurred!");
//                        errorTextView.setVisibility(View.VISIBLE);
//                        errorTextView.setText("Some Error occurred!");
//                        recyclerView.setItemViewCacheSize(View.GONE);
//                        shimmerFrameLayout.stopShimmer();
                    } else {
//                        errorTextView.setVisibility(View.GONE);
//                        shimmerFrameLayout.startShimmer();
                    }
                });
        helplineViewModel.getLoading().observe(getViewLifecycleOwner(), isLoading -> {
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
        helplineData = helplineViewModel.getHelplineResponse().getValue();
        if (helplineData == null) {
            helplineData = new HelplineData();
        }
//        helplineNumber.setText(helplineData.getHelplineNumber());
//        tollFreeNumber.setText(helplineData.getTollFreeNumber());
//        helplineEmail.setText(helplineData.getHelplineEmail());
        Log.d(TAG,helplineData.toString());
    }


    @Override
    public void onHelplineDataSelected(StateHelpline stateHelpline) {
        Log.d(TAG,"Here ");
        Intent intent;
        if (stateHelpline.getName() == "Helpline Email") {
            intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto",stateHelpline.getHelplineNumber(), null));
            startActivity(Intent.createChooser(intent, "Send Email"));
        } else {
            intent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:" + stateHelpline.getHelplineNumber()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
