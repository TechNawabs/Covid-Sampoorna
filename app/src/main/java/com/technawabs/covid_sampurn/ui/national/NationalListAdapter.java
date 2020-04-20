package com.technawabs.covid_sampurn.ui.national;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.technawabs.covid_sampurn.R;
import com.technawabs.covid_sampurn.data.model.national.NationalTimeData;
import com.technawabs.covid_sampurn.data.model.national.NationalTimeStats;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NationalListAdapter extends RecyclerView.Adapter<NationalListAdapter.NationalListViewHolder> {

    private NationalSelectedListener nationalSelectedListener;
    private NationalTimeStats nationalTimeStats = new NationalTimeStats();

    public NationalListAdapter(NationalViewModel nationalViewModel, LifecycleOwner lifecycleOwner,
                               NationalSelectedListener nationalSelectedListener) {
        this.nationalSelectedListener = nationalSelectedListener;
        nationalViewModel.getNationalResponse()
        .observe(lifecycleOwner, nationalStats -> {
            if(nationalStats != null) {
                nationalTimeStats.setNationalTimeDataList(nationalStats.getNationalTimeDataList());
                nationalTimeStats.setStatewiseDataList(nationalStats.getStatewiseDataList());
                nationalTimeStats.setTestedDataList(nationalStats.getTestedDataList());
                notifyDataSetChanged();
            }
        });
    }

    @NonNull
    @Override
    public NationalListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.national_list_item, parent, false);
        return new NationalListViewHolder(view, nationalSelectedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NationalListViewHolder holder, int position) {
        holder.bind(nationalTimeStats.getNationalTimeDataList().get(position));
    }

    @Override
    public int getItemCount() {
        return (nationalTimeStats != null && nationalTimeStats.getNationalTimeDataList() != null)
                ? nationalTimeStats.getNationalTimeDataList().size()
                : 0;
    }

    static class NationalListViewHolder extends RecyclerView.ViewHolder {

        private Context context;
        private NationalTimeData nationalTimeData;
        @BindView(R.id.dailyConfirmed) TextView dailyConfirmedTextView;
        @BindView(R.id.dailyDeceased) TextView dailyDeceasedTextView;
        @BindView(R.id.dailyRecovered) TextView dailyRecoveredTextView;
        @BindView(R.id.date) TextView dateTextView;
        @BindView(R.id.totalConfirmed) TextView totalConfirmedTextView;
        @BindView(R.id.totalDeceased) TextView totalDeceasedTextView;
        @BindView(R.id.totalRecovered) TextView totalRecoveredTextView;

        public NationalListViewHolder(@NonNull View itemView,
                                      @NonNull NationalSelectedListener nationalSelectedListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (nationalSelectedListener != null) {
                        nationalSelectedListener.onNationalStatSelected(nationalTimeData);
                    }
                }
            });
        }

        void bind(@NonNull NationalTimeData nationalTimeData) {
            if(nationalTimeData != null) {
                dailyConfirmedTextView.setText(nationalTimeData.getDailyConfirmed());
                dailyDeceasedTextView.setText(nationalTimeData.getDailyDeceased());
                dailyRecoveredTextView.setText(nationalTimeData.getDailyRecovered());
                dateTextView.setText(nationalTimeData.getDate());
                totalConfirmedTextView.setText(nationalTimeData.getTotalConfirmed());
                totalDeceasedTextView.setText(nationalTimeData.getTotalDeceased());
                totalRecoveredTextView.setText(nationalTimeData.getTotalRecovered());
            }
        }

    }

}
