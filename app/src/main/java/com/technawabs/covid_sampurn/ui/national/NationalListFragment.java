package com.technawabs.covid_sampurn.ui.national;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import androidx.lifecycle.ViewModelProviders;
import com.technawabs.covid_sampurn.R;
import com.technawabs.covid_sampurn.base.BaseFragment;
import com.technawabs.covid_sampurn.data.model.national.NationalTimeData;

import com.technawabs.covid_sampurn.ui.national.adapter.SectionsPagerAdapter;
import com.technawabs.covid_sampurn.viewmodel.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;

public class NationalListFragment extends BaseFragment implements NationalSelectedListener {

    private static final String TAG = NationalListFragment.class.getSimpleName();

//    @BindView(R.id.recyclerViewNational) RecyclerView recyclerView;
//    @BindView(R.id.errorNational) TextView errorTextView;
//    @BindView(R.id.nationalShimmerFrameLayout) ShimmerFrameLayout shimmerFrameLayout;
    //    active
    @BindView(R.id.active_number)
    TextView activeNumberTextView;
    @BindView(R.id.active_growth_up_number)
    TextView activePercentUpTextView;
    @BindView(R.id.active_growth_down_number)
    TextView activePercentDownTextView;
    @BindView(R.id.active_growth_up)
    LinearLayout activeGrowthUpView;
    @BindView(R.id.active_growth_down)
    LinearLayout activeGrowthDownView;
    //    confirmed
    @BindView(R.id.confirmed_number)
    TextView confirmedNumberTextView;
    @BindView(R.id.confirmed_growth_up_number)
    TextView confirmedPercentUpTextView;
    @BindView(R.id.confirmed_growth_down_number)
    TextView confirmedPercentDownTextView;
    @BindView(R.id.confirmed_growth_up)
    LinearLayout confirmedGrowthUpView;
    @BindView(R.id.confirmed_growth_down)
    LinearLayout confirmedGrowthDownView;
    @BindView(R.id.miniCnfGraph)
    WebView miniConfirmedGraph;
    //    recovered
    @BindView(R.id.recovered_number)
    TextView recoveredNumberTextView;
    @BindView(R.id.recovered_growth_up_number)
    TextView recoveredPercentUpTextView;
    @BindView(R.id.recovered_growth_down_number)
    TextView recoveredPercentDownTextView;
    @BindView(R.id.recovered_growth_up)
    LinearLayout recoveredGrowthUpView;
    @BindView(R.id.recovered_growth_down)
    LinearLayout recoveredGrowthDownView;
    //    deceased
    @BindView(R.id.deceased_number)
    TextView deceasedNumberTextView;
    @BindView(R.id.deceased_growth_up_number)
    TextView deceasedPercentUpTextView;
    @BindView(R.id.deceased_growth_down_number)
    TextView deceasedPercentDownTextView;
    @BindView(R.id.deceased_growth_up)
    LinearLayout deceasedGrowthUpView;
    @BindView(R.id.deceased_growth_down)
    LinearLayout deceasedGrowthDownView;
    //    Tabs
//    @BindView(R.id.view_pager)
//    ViewPager viewPager;
//    @BindView(R.id.tabs)
//    TabLayout graphViewTabs;
    @BindView(R.id.myView)
    WebView myView;
//    tabs
    @BindView(R.id.totalCard)
    CardView totalCard;
    @BindView(R.id.totalCardText)
    TextView totalCardText;
    @BindView(R.id.monthlyCard)
    CardView monthlyCard;
    @BindView(R.id.monthlyCardText)
    TextView monthlyCardText;
    @BindView(R.id.weeklyCard)
    CardView weeklyCard;
    @BindView(R.id.weeklyCardText)
    TextView weeklyCardText;


    private SectionsPagerAdapter sectionsPagerAdapter;

    @Inject
    ViewModelFactory viewModelFactory;
    private NationalViewModel nationalViewModel;

    private static final String ARG_SECTION_NUMBER = "section_number";


    @Override
    protected int layoutRes() {
        return R.layout.national_list_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        nationalViewModel = ViewModelProviders.of(this, viewModelFactory)
        .get(NationalViewModel.class);
//        GraphFragment graphFragment = new GraphFragment();
        //        recyclerView.addItemDecoration(new DividerItemDecoration(getBaseActivity(), DividerItemDecoration.VERTICAL));
//        recyclerView.setAdapter(new NationalListAdapter(nationalViewModel, this, this));
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

//        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
//        graphViewTabs = (TabLayout) view.findViewById(R.id.tabs);
//        sectionsPagerAdapter = new SectionsPagerAdapter(getContext(), getParentFragmentManager());
//        Log.d(TAG, "Sre: "+sectionsPagerAdapter.getCount());
//        viewPager.setAdapter(sectionsPagerAdapter);
//        graphViewTabs.setupWithViewPager(viewPager);

//        sectionsPagerAdapter = new SectionsPagerAdapter(getContext(), getParentFragmentManager());
//        viewPager.setAdapter(sectionsPagerAdapter);
//        graphViewTabs.setupWithViewPager(viewPager);
        tabClickLogic();
        observableViewModel();
        nationalViewModel.drawDailyChart(myView);
    }

    @Override
    public void onNationalStatSelected(NationalTimeData nationalTimeData) {
        Log.d(TAG,"onNationalStatSelected");
    }

    private void observableViewModel() {
        nationalViewModel.getNationalResponse()
        .observe(getViewLifecycleOwner(), nationalTimeStats -> {
            if(nationalTimeStats != null) {
//                recyclerView.setVisibility(View.VISIBLE);
                if (nationalTimeStats.getNationalTimeDataList() != null
                        && nationalTimeStats.getNationalTimeDataList().size() > 0) {
                    NationalTimeData lastTimeData = nationalTimeStats.getNationalTimeDataList()
                            .get(nationalTimeStats.getNationalTimeDataList().size()-1);
                    NationalTimeData secondLastTimeData = nationalTimeStats.getNationalTimeDataList()
                            .get(nationalTimeStats.getNationalTimeDataList().size()-2);
                    confirmedNumberTextView.setText(lastTimeData.totalConfirmed);
                    deceasedNumberTextView.setText(lastTimeData.totalDeceased);
                    recoveredNumberTextView.setText(lastTimeData.totalRecovered);
                    int activeNumber = Integer.parseInt(lastTimeData.totalConfirmed)
                            - Integer.parseInt(lastTimeData.totalDeceased)
                            - Integer.parseInt(lastTimeData.totalRecovered);
                    activeNumberTextView.setText(activeNumber+ "");
                    drawMiniGraph();
//                  compared confirmed
                    int compareConfirmed = Integer.parseInt(lastTimeData.totalConfirmed)
                            - Integer.parseInt(secondLastTimeData.totalConfirmed);
                    if (compareConfirmed < 0) {
                        confirmedGrowthDownView.setVisibility(View.VISIBLE);
                        confirmedGrowthUpView.setVisibility(View.INVISIBLE);
                        confirmedPercentDownTextView.setText(compareConfirmed+ "");
                    } else {
                        confirmedGrowthDownView.setVisibility(View.INVISIBLE);
                        confirmedGrowthUpView.setVisibility(View.VISIBLE);
                        confirmedPercentUpTextView.setText(compareConfirmed+ "");
                    }
                    //  compared deceased
                    int compareDeceased = Integer.parseInt(lastTimeData.totalDeceased)
                            - Integer.parseInt(secondLastTimeData.totalDeceased);
                    if (compareDeceased < 0) {
                        deceasedGrowthDownView.setVisibility(View.VISIBLE);
                        deceasedGrowthUpView.setVisibility(View.INVISIBLE);
                        deceasedPercentDownTextView.setText(compareDeceased+ "");
                    } else {
                        deceasedGrowthDownView.setVisibility(View.INVISIBLE);
                        deceasedGrowthUpView.setVisibility(View.VISIBLE);
                        deceasedPercentUpTextView.setText(compareDeceased+ "");
                    }
                    //  compared recovered
                    int compareRecovered = Integer.parseInt(lastTimeData.totalRecovered)
                            - Integer.parseInt(secondLastTimeData.totalRecovered);
                    if (compareRecovered < 0) {
                        recoveredGrowthDownView.setVisibility(View.VISIBLE);
                        recoveredGrowthUpView.setVisibility(View.INVISIBLE);
                        recoveredPercentDownTextView.setText(compareRecovered+ "");
                    } else {
                        recoveredGrowthDownView.setVisibility(View.INVISIBLE);
                        recoveredGrowthUpView.setVisibility(View.VISIBLE);
                        recoveredPercentUpTextView.setText(compareRecovered+ "");
                    }
                    //  compared active
                    int secondActiveNumber = Integer.parseInt(lastTimeData.totalConfirmed)
                            - Integer.parseInt(lastTimeData.totalDeceased)
                            - Integer.parseInt(lastTimeData.totalRecovered);
                    int compareActive = activeNumber - secondActiveNumber;
                    if (compareActive < 0) {
                        activeGrowthDownView.setVisibility(View.VISIBLE);
                        activeGrowthUpView.setVisibility(View.INVISIBLE);
                        activePercentDownTextView.setText(compareActive+ "");
                    } else {
                        activeGrowthDownView.setVisibility(View.INVISIBLE);
                        activeGrowthUpView.setVisibility(View.VISIBLE);
                        activePercentUpTextView.setText(compareActive+ "");
                    }
                }
            }
        });

        nationalViewModel.getRepoLoadError()
                .observe(getViewLifecycleOwner(), isError -> {
                    if (isError) {
//                        errorTextView.setVisibility(View.VISIBLE);
//                        errorTextView.setText("Some Error occurred!");
//                        recyclerView.setItemViewCacheSize(View.GONE);
//                        shimmerFrameLayout.stopShimmer();
                    } else {
//                        errorTextView.setVisibility(View.GONE);
//                        shimmerFrameLayout.startShimmer();
                    }
                });
        nationalViewModel.getLoading().observe(getViewLifecycleOwner(), isLoading -> {
            if(isLoading != null) {
                if(isLoading) {
//                    errorTextView.setVisibility(View.GONE);
//                    recyclerView.setVisibility(View.GONE);
//                    shimmerFrameLayout.startShimmer();
                } else {
//                    shimmerFrameLayout.stopShimmer();
                }
            }
        });
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void drawMiniGraph() {
        String miniConfirm = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head></head>\n" +
                "<body>\n" +
                "\t<canvas id=\"myAreaChart\" height=\"500\"></canvas>\n" +
                "\t<script src=\"https://cdn.jsdelivr.net/npm/chart.js@2.9.3\"></script>\n" +
                "\t<script>\n" +
                "\t  var ctx = document.getElementById('myAreaChart').getContext('2d');\n" +
                "\t  var chart = new Chart(ctx, {\n" +
                "\t  type: 'line',\n" +
                "\t\t\n" +
                "\t  data: {\n" +
                "\t\tlabels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],\n" +
                "\t\tdatasets: [{\n" +
                "\t\t\tbackgroundColor: \"rgba(172,194,132,0.4)\",\n" +
                "\t\t\tborderColor: \"#ACC26D\",\n" +
                "\t\t\tdata : [203,156,99,251,305,247,450],\n" +
                "\t\t\thidden: false,\n" +
                "\t\t}] \n" +
                "\t},\n" +
                "\t\t\t\t\t\t\n" +
                "\toptions: {\n" +
                "\t\tmaintainAspectRatio: false,\n" +
                "\t\tspanGaps: false,\n" +
                "\t\tlegend: {\n" +
                "            display: false\n" +
                "        },\n" +
                "\t\telements: {\n" +
                "\t\t\tline: {\n" +
                "\t\t\t\ttension: 0.4\n" +
                "\t\t\t}\n" +
                "\t\t},\n" +
                "\t\tscales: {\n" +
                "\t\t\txAxes: [{\n" +
                "\t\t\t\tgridLines: {\n" +
                "\t\t\t\t\tdisplay:false\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}],\n" +
                "\t\t\tyAxes: [{\n" +
                "\t\t\t\tgridLines: {\n" +
                "\t\t\t\t\tdisplay:false\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\tticks: {\n" +
                "\t\t\t\t\tdisplay: false\n" +
                "\t\t\t\t}\t\n" +
                "\t\t\t}]\n" +
                "\t\t},\n" +
                "\t\tplugins: {\n" +
                "\t\t\tfiller: {\n" +
                "\t\t\t\tpropagate: true\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t}\n" +
                "});\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>";

        miniConfirmedGraph.getSettings().setJavaScriptEnabled(true);
        miniConfirmedGraph.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        miniConfirmedGraph.loadDataWithBaseURL(null, miniConfirm, "text/html", "UTF-8", null);
    }

    private void tabClickLogic() {
//        set total as active
        totalCard.setCardBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        totalCardText.setTextColor(getResources().getColor(R.color.white));

        totalCardText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalCard.getCardBackgroundColor().getDefaultColor() == getResources().getColor(R.color.design_default_color_primary)) {
//                    set inactive
                    totalCard.setCardBackgroundColor(getResources().getColor(R.color.white));
                    totalCardText.setTextColor(getResources().getColor(R.color.black_overlay));
                } else {
//                    set active
                    totalCard.setCardBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
                    totalCardText.setTextColor(getResources().getColor(R.color.white));

                    weeklyCard.setCardBackgroundColor(getResources().getColor(R.color.white));
                    weeklyCardText.setTextColor(getResources().getColor(R.color.black_overlay));

                    monthlyCard.setCardBackgroundColor(getResources().getColor(R.color.white));
                    monthlyCardText.setTextColor(getResources().getColor(R.color.black_overlay));

                }
            }
        });

        weeklyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (weeklyCard.getCardBackgroundColor().getDefaultColor() == getResources().getColor(R.color.design_default_color_primary)) {
//                    set inactive
                    weeklyCard.setCardBackgroundColor(getResources().getColor(R.color.white));
                    weeklyCardText.setTextColor(getResources().getColor(R.color.black_overlay));
                } else {
//                    set active
                    weeklyCard.setCardBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
                    weeklyCardText.setTextColor(getResources().getColor(R.color.white));

                    totalCard.setCardBackgroundColor(getResources().getColor(R.color.white));
                    totalCardText.setTextColor(getResources().getColor(R.color.black_overlay));

                    monthlyCard.setCardBackgroundColor(getResources().getColor(R.color.white));
                    monthlyCardText.setTextColor(getResources().getColor(R.color.black_overlay));
                }
            }
        });

        monthlyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (monthlyCard.getCardBackgroundColor().getDefaultColor() == getResources().getColor(R.color.design_default_color_primary)) {
//                    set inactive
                    monthlyCard.setCardBackgroundColor(getResources().getColor(R.color.white));
                    monthlyCardText.setTextColor(getResources().getColor(R.color.black_overlay));
                } else {
//                    set active
                    monthlyCard.setCardBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
                    monthlyCardText.setTextColor(getResources().getColor(R.color.white));

                    totalCard.setCardBackgroundColor(getResources().getColor(R.color.white));
                    totalCardText.setTextColor(getResources().getColor(R.color.black_overlay));

                    weeklyCard.setCardBackgroundColor(getResources().getColor(R.color.white));
                    weeklyCardText.setTextColor(getResources().getColor(R.color.black_overlay));

                }
            }
        });
    }

}
