package com.technawabs.covid_sampurn.ui.helplines;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.technawabs.covid_sampurn.R;
import com.technawabs.covid_sampurn.data.model.helpline.StateHelpline;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HelplineListAdapter extends RecyclerView.Adapter<HelplineListAdapter.HelplineViewHolder> {

    private HelplineSelectedListener helplineSelectedListener;
    private List<StateHelpline> stateHelplines;

    public HelplineListAdapter(@NonNull List<StateHelpline> stateHelplines,
                               @NonNull HelplineSelectedListener helplineSelectedListener) {
        this.helplineSelectedListener = helplineSelectedListener;
        this.stateHelplines = stateHelplines;
    }

    @NonNull
    @Override
    public HelplineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.helpline_list_item, parent, false);
        return new HelplineListAdapter.HelplineViewHolder(view, helplineSelectedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull HelplineViewHolder holder, int position) {
        holder.bind(stateHelplines.get(position));
    }

    @Override
    public int getItemCount() {
        return stateHelplines.size();
    }

    static class HelplineViewHolder extends RecyclerView.ViewHolder {

        private Context context;
        private StateHelpline stateHelpline;

        @BindView(R.id.stateName)
        TextView stateName;
        @BindView(R.id.stateHelplineNumber)
        TextView stateHelplineNumber;
        @BindView(R.id.stateHelpline)
        LottieAnimationView stateHelplineView;
        @BindView(R.id.helplineEmail)
        LottieAnimationView helplineEmail;


        public HelplineViewHolder(@NonNull View itemView,
                                  @NonNull HelplineSelectedListener helplineSelectedListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   if (helplineSelectedListener != null) {
                       helplineSelectedListener.onHelplineDataSelected(stateHelpline);
                   }
                }
            });
        }

        void bind(@NonNull StateHelpline stateHelpline) {
            this.stateHelpline = stateHelpline;
            if (stateHelpline.getName() == "Helpline Email") {
                this.stateHelplineView.setAlpha(0f);
                this.helplineEmail.setAlpha(1f);
            } else {
                this.stateHelplineView.setAlpha(1f);
                this.helplineEmail.setAlpha(0f);
            }
            this.stateName.setText(stateHelpline.getName());
            this.stateHelplineNumber.setText(stateHelpline.getHelplineNumber());
        }

    }
}
