package com.technawabs.covid_sampurn.ui.travel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.technawabs.covid_sampurn.R;
import com.technawabs.covid_sampurn.data.model.travel.TravelData;
import com.technawabs.covid_sampurn.data.model.travel.TravelStat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TravelListAdapter extends RecyclerView.Adapter<TravelListAdapter.TravelListViewHolder> {

    private TravelSelectedListener travelSelectedListener;
    private TravelStat travelStat = new TravelStat();

    public TravelListAdapter(TravelViewModel travelViewModel, LifecycleOwner lifecycleOwner,
                             TravelSelectedListener travelSelectedListener) {
        this.travelSelectedListener = travelSelectedListener;
        travelViewModel.getTravelStatResponse()
                .observe(lifecycleOwner, travelStat -> {
                    if(travelStat != null) {
                        this.travelStat.setTravelDataList(travelStat.getTravelDataList());
                        notifyDataSetChanged();
                    }
                });
    }

    @NonNull
    @Override
    public TravelListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.travel_list_item, parent, false);
        return new TravelListAdapter.TravelListViewHolder(view, travelSelectedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TravelListViewHolder holder, int position) {
        holder.bind(travelStat.getTravelDataList().get(position));
    }

    @Override
    public int getItemCount() {
        return (travelStat != null && travelStat.getTravelDataList() != null)
                ? travelStat.getTravelDataList().size()
                : 0;
    }

    static class TravelListViewHolder extends RecyclerView.ViewHolder {

        private TravelData travelData;
        private Context context;
        @BindView(R.id.code) TextView codeTextView;
        @BindView(R.id.accuracyLocation) TextView accuracyLocationTextView;
        @BindView(R.id.address) TextView addressTextView;
        @BindView(R.id.dataSource) TextView dataSourceTextView;
        @BindView(R.id.latlong) TextView latlongTextView;
        @BindView(R.id.modeOfTravel) TextView modeOfTravelTextView;
        @BindView(R.id.pid) TextView pidTextView;
        @BindView(R.id.placeName) TextView placeNameTextView;
        @BindView(R.id.timeFrom) TextView timeFromTextView;
        @BindView(R.id.timeTo) TextView timeToTextView;
        @BindView(R.id.type) TextView typeTextView;

        public TravelListViewHolder(@NonNull View itemView, @NonNull TravelSelectedListener travelSelectedListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(travelSelectedListener != null) {
                        travelSelectedListener.onTravelStatSelected(travelData);
                    }
                }
            });
        }

        void bind(@NonNull TravelData travelData) {
            this.travelData = travelData;
            if (this.travelData != null) {
                codeTextView.setText(travelData.getCode());
                accuracyLocationTextView.setText(travelData.getAccuracyLocation());
                addressTextView.setText(travelData.getAddress());
                dataSourceTextView.setText(travelData.getDataSource());
                latlongTextView.setText(travelData.getLatlong());
                modeOfTravelTextView.setText(travelData.getModeOfTravel());
                pidTextView.setText(travelData.getPid());
                placeNameTextView.setText(travelData.getPlaceName());
                timeFromTextView.setText(travelData.getTimeFrom());
                timeToTextView.setText(travelData.getTimeTo());
                typeTextView.setText(travelData.getType());
            }
        }

    }

}
