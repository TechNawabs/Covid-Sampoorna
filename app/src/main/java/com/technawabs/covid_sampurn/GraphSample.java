package com.technawabs.covid_sampurn;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class GraphSample extends AppCompatActivity {

    WebView mView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_sample);

        mView = findViewById(R.id.myGraph);

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

        mView.getSettings().setJavaScriptEnabled(true);
        mView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mView.loadDataWithBaseURL(null, content, "text/html", "UTF-8", null);
    }
}
