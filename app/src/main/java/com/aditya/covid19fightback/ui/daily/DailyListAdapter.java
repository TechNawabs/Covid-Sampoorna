package com.aditya.covid19fightback.ui.daily;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.covid19fightback.R;
import com.aditya.covid19fightback.data.model.daily.DailyData;
import com.aditya.covid19fightback.data.model.daily.DailyStates;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DailyListAdapter extends RecyclerView.Adapter<DailyListAdapter.DailyListViewHolder> {

    private DailySelectedListener dailySelectedListener;
    private DailyStates dailyStates = new DailyStates();

    public DailyListAdapter(DailyViewModel dailyViewModel, LifecycleOwner lifecycleOwner,
                            DailySelectedListener dailySelectedListener) {
        this.dailySelectedListener = dailySelectedListener;
        dailyViewModel.getDailyResponse()
                .observe(lifecycleOwner, dailyStates -> {
                    if(dailyStates != null) {
                        this.dailyStates.setDailyStates(dailyStates.getDailyStates());
                        notifyDataSetChanged();
                    }
                });
    }

    @NonNull
    @Override
    public DailyListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.daily_list_item, parent, false);
        return new DailyListAdapter.DailyListViewHolder(view, dailySelectedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyListViewHolder holder, int position) {
        holder.bind(dailyStates.getDailyStates().get(position));
    }

    @Override
    public int getItemCount() {
        return (dailyStates != null && dailyStates.getDailyStates() != null)
                ? dailyStates.getDailyStates().size()
                : 0;
    }


    static class DailyListViewHolder extends RecyclerView.ViewHolder {

        private DailyData dailyData;
        @BindView(R.id.anTitle) TextView anTextView;
        @BindView(R.id.apTitle) TextView apTextView;
        @BindView(R.id.arTitle) TextView arTextView;
        @BindView(R.id.asTitle) TextView asTextView;
        @BindView(R.id.brTitle) TextView brTextView;
        @BindView(R.id.chTitle) TextView chTextView;
        @BindView(R.id.ctTitle) TextView ctTextView;
        @BindView(R.id.dateTitle) TextView dateTextView;

        public DailyListViewHolder(@NonNull View itemView,
                                   @NonNull DailySelectedListener dailySelectedListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (dailySelectedListener != null) {
                        dailySelectedListener.onDailyStatSelected(dailyData);

                    }
                }
            });
        }

        void bind(@NonNull DailyData dailyData) {
            this.dailyData = dailyData;
            if(this.dailyData != null) {
                this.anTextView.setText(this.dailyData.getAn());
                this.apTextView.setText(this.dailyData.getAp());
                this.arTextView.setText(this.dailyData.getAr());
                this.asTextView.setText(this.dailyData.getAs());
                this.brTextView.setText(this.dailyData.getBr());
                this.chTextView.setText(this.dailyData.getCh());
                this.ctTextView.setText(this.dailyData.getCt());
                this.dateTextView.setText(this.dailyData.getDate());
            }
        }

    }

}
