package com.technawabs.covid_sampurn.ui.national;

import android.view.View;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.technawabs.covid_sampurn.data.model.national.NationalTimeData;
import com.technawabs.covid_sampurn.data.model.national.NationalTimeStats;
import com.technawabs.covid_sampurn.data.rest.national.NationalRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class NationalViewModel extends ViewModel {

    private final NationalRepository nationalRepository;
    private CompositeDisposable compositeDisposable;

    private final MutableLiveData<NationalTimeStats> nationalTimeResponse = new MutableLiveData<NationalTimeStats>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public NationalViewModel(NationalRepository nationalRepository) {
        this.nationalRepository = nationalRepository;
        compositeDisposable = new CompositeDisposable();
        fetchNationalTimeStat();
    }

    public MutableLiveData<NationalTimeStats> getNationalResponse() {
        return nationalTimeResponse;
    }

    public MutableLiveData<Boolean> getRepoLoadError() {
        return repoLoadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public void fetchNationalTimeStat() {
        loading.setValue(true);
        compositeDisposable.add(nationalRepository.loadNationalTimeStats()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<NationalTimeStats>() {
                    @Override
                    public void onSuccess(NationalTimeStats nationalTimeStats) {
                        repoLoadError.setValue(false);
                        nationalTimeResponse.setValue(nationalTimeStats);
                        loading.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        repoLoadError.setValue(true);
                        loading.setValue(false);
                    }
                }));
    }

    public void drawDailyChart(@NonNull WebView myView, @NonNull List<NationalTimeData> nationalTimeDataList) {
        List<String> dailyConfirmed = new ArrayList<String>();
        List<String> dailyDeceased = new ArrayList<String>();
        List<String> dailyRecovered = new ArrayList<String>();
        List<String> days = new ArrayList<>();
        for(NationalTimeData nationalTimeData: nationalTimeResponse.getValue().getNationalTimeDataList()) {
            dailyConfirmed.add(nationalTimeData.getDailyConfirmed());
            dailyDeceased.add(nationalTimeData.getDailyDeceased());
            dailyRecovered.add(nationalTimeData.getDailyRecovered());
        }
        for(int i=0;i<nationalTimeResponse.getValue().getNationalTimeDataList().size();i++){
            days.add(i+"");
        }
        String dailyConfirmedData = dailyConfirmed.toString();
        String dailyDeceasedData = dailyDeceased.toString();
        String dailyRecoveredData = dailyRecovered.toString();

        String content = "<!DOCTYPE HTML>\n" +
                "<html>\n" +
                "<head></head>\n" +
                "<body>\n" +
                "<canvas id=\"mychart\"></canvas>\n" +
                "<script src=\"https://cdn.jsdelivr.net/npm/chart.js@2.8.0\"></script>\n" +
                "<script>\n" +
                "var ctx = document.getElementById(\"mychart\").getContext(\"2d\");\n" +
                "var chart = new Chart(ctx, {\n" +
                "type: 'line',\n" +
                "data: {\n" +
                "labels: " +
                days +
                ",\n" +
                "datasets: [" +
                "{\n" +
                "label: \"Confirmed\",\n" +
                "backgroundColor: \"rgba(255, 128, 171, 0.4)\",\n" +
                "data: " +
                dailyConfirmedData +
                "\n" +
                "}, \n" +
                "{\n" +
                "label: \"Recovered\",\n" +
                "backgroundColor: \"rgba(179, 136, 255, 0.6)\",\n" +
                "data: " +
                dailyDeceasedData +
                "\n" +
                "}" +
                "]\n" +
                "},\n" +
                "options: {\n" +
                "scales: {\n" +
                "xAxes: [{\n" +
                "gridLines: {\n" +
                "display:false\n" +
                "}\n" +
                "}],\n" +
                "yAxes: [{\n" +
                "gridLines: {\n" +
                "display:false\n" +
                "}   \n" +
                "}]\n" +
                "}\n" +
                "}\n" +
                "});\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>";

        myView.getSettings().setJavaScriptEnabled(true);
        myView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        myView.loadDataWithBaseURL(null, content, "text/html", "UTF-8", null);
    }

    public void drawWeeklyChart() {

    }

    public void drawMonthlyChart() {

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (compositeDisposable != null) {
            compositeDisposable.clear();
            compositeDisposable = null;
        }
    }

}


