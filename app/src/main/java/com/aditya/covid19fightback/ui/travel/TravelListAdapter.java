package com.aditya.covid19fightback.ui.travel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.covid19fightback.R;
import com.aditya.covid19fightback.data.model.state.StateData;
import com.aditya.covid19fightback.data.model.travel.TravelData;
import com.aditya.covid19fightback.data.model.travel.TravelStat;
import com.aditya.covid19fightback.ui.national.NationalListAdapter;

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

        public TravelListViewHolder(@NonNull View itemView, @NonNull TravelSelectedListener travelSelectedListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(travelSelectedListener != null) {

                    }
                }
            });
        }

        void bind(@NonNull TravelData travelData) {
            if (travelData != null) {

            }
        }

    }

}
