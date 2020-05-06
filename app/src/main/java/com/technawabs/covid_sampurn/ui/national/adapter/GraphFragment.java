package com.technawabs.covid_sampurn.ui.national.adapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.technawabs.covid_sampurn.R;
import com.technawabs.covid_sampurn.base.BaseFragment;

import butterknife.BindView;

public class GraphFragment extends BaseFragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private GraphViewModel mViewModel;
    @BindView(R.id.myView)
    WebView myView;
    int state;

    public static GraphFragment newInstance(int index) {
        GraphFragment graphFragment = new GraphFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        graphFragment.setArguments(bundle);
        return graphFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GraphViewModel.class);
        int index = 1;
        if(getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
            state = index;
        }
    }

    @Override
    protected int layoutRes() {
        return R.layout.graph_fragment;
    }

//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        View root = inflater.inflate(R.layout.graph_fragment, container, false);
//        anyChartView = (AnyChartView) root.findViewById(R.id.any_chart_view);
//        switch (state) {
//            case 2:
//                drawWeeklyChart();
//                break;
//            case 3:
//                drawMonthlyChart();
//                break;
//            case 1:
//                drawDailyChart();
//                break;
//        }
//        return root;
//    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        switch (state) {
            case 2:
                drawWeeklyChart();
                break;
            case 3:
                drawMonthlyChart();
                break;
            case 1:
                drawDailyChart();
                break;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GraphViewModel.class);
        // TODO: Use the ViewModel
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void drawDailyChart() {
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
                "labels: [\"January\", \"February\", \"March\", \"April\", \"May\", \"June\", \"July\"],\n" +
                "datasets: [{\n" +
                "label: \"My First dataset\",\n" +
                "backgroundColor: \"rgba(255, 128, 171, 0.4)\",\n" +
                "data: [65, 59, 80, 81, 56, 55, 40]\n" +
                "}, \n" +
                "{\n" +
                "label: \"My Second dataset\",\n" +
                "backgroundColor: \"rgba(179, 136, 255, 0.6)\",\n" +
                "data: [28, 48, 40, 19, 86, 27, 90]\n" +
                "}]\n" +
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

//        anyChartView.setProgressBar(findViewById(R.id.progress_bar));
//        Cartesian areaChart = AnyChart.area();
//
//        areaChart.animation(true);
//
//        Crosshair crosshair = areaChart.crosshair();
//        crosshair.enabled(true);
//        // TODO yStroke xStroke in crosshair
//        crosshair.yStroke((Stroke) null, null, null, (String) null, (String) null)
//                .xStroke("#fff", 1d, null, (String) null, (String) null)
//                .zIndex(39d);
//        crosshair.yLabel(0).enabled(true);
//
//        areaChart.yScale().stackMode(ScaleStackMode.VALUE);
//
//        areaChart.title("Spread Trends");
//
//        List<DataEntry> seriesData = new ArrayList<>();
//        seriesData.add(new CustomDataEntry("Q2 2014", 17.982, 10.941, 9.835, 4.047, 2.841));
//        seriesData.add(new CustomDataEntry("Q3 2014", 17.574, 8.659, 6.230, 2.627, 2.242));
//        seriesData.add(new CustomDataEntry("Q4 2014", 19.75, 10.35, 6.292, 3.595, 2.136));
//        seriesData.add(new CustomDataEntry("Q1 2015", 30.6, 17.2, 16.1, 5.4, 5.2));
//        seriesData.add(new CustomDataEntry("Q2 2015", 21.316, 12.204, 16.823, 3.457, 4.210));
//        seriesData.add(new CustomDataEntry("Q3 2015", 20.209, 10.342, 13.23, 2.872, 2.959));
//        seriesData.add(new CustomDataEntry("Q4 2015", 21.773, 10.577, 12.518, 3.929, 2.704));
//        seriesData.add(new CustomDataEntry("Q1 2016", 29.3, 17.9, 18.4, 4.8, 5.4));
//
//        Set set = Set.instantiate();
//        set.data(seriesData);
//        Mapping series1Data = set.mapAs("{ x: 'x', value: 'value' }");
//        Mapping series2Data = set.mapAs("{ x: 'x', value: 'value2' }");
//        Mapping series3Data = set.mapAs("{ x: 'x', value: 'value3' }");
//
//        Area series1 = areaChart.area(series1Data);
//        series1.name("Confirmed");
//        series1.stroke("3 #fff");
//        series1.hovered().stroke("3 #fff");
//        series1.hovered().markers().enabled(true);
//        series1.hovered().markers()
//                .type(MarkerType.CIRCLE)
//                .size(4d)
//                .stroke("1.5 #fff");
//        series1.markers().zIndex(100d);
//
//        Area series2 = areaChart.area(series2Data);
//        series2.name("Recovered");
//        series2.stroke("3 #fff");
//        series2.hovered().stroke("3 #fff");
//        series2.hovered().markers().enabled(true);
//        series2.hovered().markers()
//                .type(MarkerType.CIRCLE)
//                .size(4d)
//                .stroke("1.5 #fff");
//        series2.markers().zIndex(100d);
//
//        Area series3 = areaChart.area(series3Data);
//        series3.name("Deceased");
//        series3.stroke("3 #fff");
//        series3.hovered().stroke("3 #fff");
//        series3.hovered().markers().enabled(true);
//        series3.hovered().markers()
//                .type(MarkerType.CIRCLE)
//                .size(4d)
//                .stroke("1.5 #fff");
//        series3.markers().zIndex(100d);
//
//        areaChart.legend().enabled(true);
//        areaChart.legend().fontSize(13d);
//        areaChart.legend().padding(0d, 0d, 20d, 0d);
//
//        areaChart.xAxis(0).title(false);
//        areaChart.yAxis(0).title("Revenue (in Billons USD)");
//
//        areaChart.interactivity().hoverMode(HoverMode.BY_X);
//        areaChart.tooltip()
//                .valuePrefix("$")
//                .valuePostfix(" bln.")
//                .displayMode(TooltipDisplayMode.UNION);
//
//        anyChartView.setChart(areaChart);
    }

    public void drawWeeklyChart() {

    }

    public void drawMonthlyChart() {

    }

    private class CustomDataEntry extends ValueDataEntry {
        CustomDataEntry(String x, Number value, Number value2, Number value3, Number value4, Number value5) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
            setValue("value4", value4);
            setValue("value5", value5);
        }
    }

}
