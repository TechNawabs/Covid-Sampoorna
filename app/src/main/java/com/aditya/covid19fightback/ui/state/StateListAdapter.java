package com.aditya.covid19fightback.ui.state;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.covid19fightback.R;
import com.aditya.covid19fightback.data.model.state.StateData;
import com.aditya.covid19fightback.data.model.state.StateStat;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StateListAdapter extends RecyclerView.Adapter<StateListAdapter.StateListViewHolder> {

    private StateSelectedListener stateSelectedListener;
    private List<StateData> stateStat = new ArrayList<StateData>();

    public StateListAdapter(StateViewModel stateViewModel, LifecycleOwner lifecycleOwner,
                            StateSelectedListener stateSelectedListener) {
        this.stateSelectedListener = stateSelectedListener;
        stateViewModel.getStateResponse()
                .observe(lifecycleOwner, stateStat -> {
                    if(stateStat != null) {
                        this.stateStat.addAll(stateStat);
                        notifyDataSetChanged();
                    }
                });
    }

    @NonNull
    @Override
    public StateListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.state_list_item, parent, false);
        return new StateListAdapter.StateListViewHolder(view, stateSelectedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull StateListViewHolder holder, int position) {
        holder.bind(stateStat.get(position));
    }

    @Override
    public int getItemCount() {
        return (stateStat != null)
                ? stateStat.size()
                : 0;
    }

    static class StateListViewHolder extends RecyclerView.ViewHolder {

        private StateData stateData;
        private Context context;
        @BindView(R.id.state) TextView stateTextView;
        @BindView(R.id.district) TextView districtTextView;
        @BindView(R.id.confirmed) TextView confirmedTextView;
        @BindView(R.id.lastUpdatedTime) TextView lastUpdatedTimeTextView;

        public StateListViewHolder(@NonNull View itemView, @NonNull StateSelectedListener stateSelectedListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(stateSelectedListener != null) {
                        stateSelectedListener.onStateStatSelected(stateData);
                    }
                }
            });
        }

        void bind(@NonNull StateData stateData) {
            this.stateData = stateData;
            if (stateData != null) {
                stateTextView.setText(stateData.getState());
                districtTextView.setText("District: "+stateData.getDistrictData().size() + "");
                confirmedTextView.setText("Confirmed: " + stateData.getDistrictsConfirmedCases());
//                lastUpdatedTimeTextView.setText(stateData.getDistrictData());
            }
        }

    }

}
