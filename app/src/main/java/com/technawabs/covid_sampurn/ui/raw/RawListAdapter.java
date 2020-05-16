package com.technawabs.covid_sampurn.ui.raw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.technawabs.covid_sampurn.R;
import com.technawabs.covid_sampurn.data.model.raw.RawData;
import com.technawabs.covid_sampurn.data.model.raw.RawStat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RawListAdapter extends RecyclerView.Adapter<RawListAdapter.RawListViewHolder> {

    private RawSelectedListener rawSelectedListener;
    private RawStat rawStat = new RawStat();

    public RawListAdapter(RawViewModel rawViewModel, LifecycleOwner lifecycleOwner,
                          RawSelectedListener rawSelectedListener) {
        this.rawSelectedListener = rawSelectedListener;
        rawViewModel.getRawResponse()
                .observe(lifecycleOwner, rawStat -> {
                    if(rawStat != null) {
                        this.rawStat.setRawStatList(rawStat.getRawStatList());
                        notifyDataSetChanged();
                    }
                });
    }

    @NonNull
    @Override
    public RawListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_list_item, parent, false);
        return new RawListAdapter.RawListViewHolder(view, rawSelectedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RawListViewHolder holder, int position) {
        holder.bind(rawStat.getRawStatList().get(position));
    }

    @Override
    public int getItemCount() {
        return (rawStat != null && rawStat.getRawStatList() != null)
                ? rawStat.getRawStatList().size()
                : 0;
    }

    static class RawListViewHolder extends RecyclerView.ViewHolder {

        private RawData rawData;
        private Context context;
        @BindView(R.id.backupNotes) TextView backupNotesTextView;
        @BindView(R.id.ageBracket) TextView ageBracketTextView;
        @BindView(R.id.contractedFromWhichPatientSuspected) TextView contractedFromWhichPatientSuspectedTextView;
        @BindView(R.id.currentStatus) TextView currentStatusTextView;
        @BindView(R.id.dateAnnounced) TextView dateAnnouncedTextView;
        @BindView(R.id.detectedCity) TextView detectedCityTextView;
//        @BindView(R.id.detectedDistrict) TextView detectedDistrictTextView;
        @BindView(R.id.detectedState) TextView detectedStateTextView;
//        @BindView(R.id.estimatedOnSetDate) TextView estimatedOnSetDateTextView;
        @BindView(R.id.gender) TextView genderTextView;
        @BindView(R.id.nationality) TextView nationalityTextView;
        @BindView(R.id.notes) TextView notesTextView;
        @BindView(R.id.patientNumber) TextView patientNumberTextView;
        @BindView(R.id.source1) TextView source1TextView;
        @BindView(R.id.source2) TextView source2TextView;
        @BindView(R.id.source3) TextView source3TextView;
//        @BindView(R.id.stateCode) TextView stateCodeTextView;
        @BindView(R.id.statePatientNumber) TextView statePatientNumberTextView;
        @BindView(R.id.statusChangeDate) TextView statusChangeDateTextView;
        @BindView(R.id.typeOfTransmission) TextView typeOfTransmissionTextView;

        public RawListViewHolder(@NonNull View itemView, @NonNull RawSelectedListener rawSelectedListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(rawSelectedListener != null) {
                        rawSelectedListener.onRawStatSelected(rawData);
                    }
                }
            });
        }

        void bind(@NonNull RawData rawData) {
            this.rawData = rawData;
            if (rawData != null) {
                backupNotesTextView.setText(rawData.getBackupNotes());
                ageBracketTextView.setText(rawData.getAgeBracket().isEmpty() ? "NA" : rawData.getAgeBracket() + " years");
                contractedFromWhichPatientSuspectedTextView
                        .setText(rawData.getContractedFromWhichPatientSuspected().isEmpty() ? "NA" : rawData.getContractedFromWhichPatientSuspected());
                currentStatusTextView.setText(rawData.getCurrentStatus().isEmpty() ? "NA" : rawData.getCurrentStatus());
                dateAnnouncedTextView.setText(rawData.getDateAnnounced().isEmpty() ? "NA" : rawData.getDateAnnounced());
                detectedCityTextView.setText(rawData.getDetectedCity().isEmpty() ? "NA" : rawData.getDetectedCity());
//                detectedDistrictTextView.setText(rawData.getDetectedDistrict());
                detectedStateTextView.setText(rawData.getDetectedState().isEmpty() ? "NA" : rawData.getDetectedState());
//                estimatedOnSetDateTextView.setText(rawData.getEstimatedOnSetDate());
                genderTextView.setText(rawData.getGender().isEmpty() ? "NA" : rawData.getGender());
                nationalityTextView.setText(rawData.getNationality().isEmpty() ? "NA" : rawData.getNationality());
                notesTextView.setText(rawData.getNotes().isEmpty() ? "NA" : rawData.getNotes());
                patientNumberTextView.setText(rawData.getPatientNumber().isEmpty() ? "NA" : rawData.getPatientNumber());
                source1TextView.setText(rawData.getSource1().isEmpty() ? "NA" : rawData.getSource1());
                source2TextView.setText(rawData.getSource2().isEmpty() ? "NA" : rawData.getSource2());
                source3TextView.setText(rawData.getSource3().isEmpty() ? "NA" : rawData.getSource3());
//                stateCodeTextView.setText(rawData.getStateCode().isEmpty() ? "NA" : rawData.getStateCode());
                statePatientNumberTextView.setText(rawData.getStatePatientNumber().isEmpty() ? "NA" : rawData.getStatePatientNumber());
                statusChangeDateTextView.setText(rawData.getStatusChangeDate().isEmpty() ? "NA" : rawData.getStatusChangeDate());
                typeOfTransmissionTextView.setText(rawData.getTypeOfTransmission().isEmpty() ? "NA" : rawData.getTypeOfTransmission());

            }
        }

    }

}
