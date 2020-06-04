package com.technawabs.covid_sampurn.ui.national;

import android.annotation.SuppressLint;
import android.graphics.Color;
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
    @BindView(R.id.miniActvGraph)
    WebView miniActiveGraph;
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
    @BindView(R.id.miniRecvGraph)
    WebView miniRecoveredGraph;
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
    @BindView(R.id.miniDescGraph)
    WebView miniDeceasedGraph;
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
        String miniConfirm = "<html>\n" +
                "<body>\n" +
                "\t<svg width=\"150\" height=\"200\">\n" +
                "\t\t<path \n" +
                "\t\t\tid=\"my-path\"\n" +
                "\t\t\tfill=\"none\" \n" +
                "\t\t\tstroke=\"#ff073a99\" \n" +
                "\t\t\tstroke-width=\"2.5\"\t\n" +
                "\t\t\ttranslate\n" +
                "\t\t\ttransform=\"scale(1,2) translate(0 -15)\"\n" +
                "\t\t\td=\"M5,34.37622496804431C6.5,34.238282914358756,8,34.1003408606732,9.5,33.88708990200256C11,33.673838943331916,12.5,33.096719216020446,14,33.096719216020446C15.5,33.096719216020446,17,33.64252236898168,18.5,33.64252236898168C20,33.64252236898168,21.5,31.208777162334886,23,30.701746910950146C24.5,30.194716659565405,26,29.941201533873034,27.5,29.941201533873034C29,29.941201533873034,30.5,31.1968470387729,32,31.1968470387729C33.5,31.1968470387729,35,26.645504899872172,36.5,26.645504899872172C38,26.645504899872172,39.5,27.93992330634853,41,27.93992330634853C42.5,27.93992330634853,44,27.44184064763528,45.5,27.036216446527483C47,26.630592245419685,48.5,25.762675756284622,50,25.50617809970175C51.5,25.249680443118876,53.00000000000001,25.377929271410313,54.50000000000001,25.12143161482744C56.00000000000001,24.864933958244567,57.5,23.791222837665103,59,23.791222837665103C60.5,23.791222837665103,62,25.271552336315864,63.5,25.870046868342566C65,26.46854140036927,66.5,27.38219002982531,68,27.38219002982531C69.5,27.38219002982531,71,23.4044879988638,72.5,23.388581167447807C74,23.372674336031814,75.5,23.380627751739812,77,23.36472092032382C78.5,23.348814088907826,80,21.177531600624913,81.5,20.728163613123137C83,20.27879562562136,84.5,20.377716233489558,86,20.05411163187047C87.5,19.73050703025138,89,18.78653600340861,90.5,18.78653600340861C92,18.78653600340861,93.5,20.376224968044312,95,21.965913932680017\" stroke-dasharray=\"98.95734405517578\" stroke-dashoffset=\"0\">\n" +
                "\t\t\t<animate attributeName=\"stroke-dashoffset\" values=\"98.95734405517578;0\" dur=\"2s\" repeatCount=\"once\" />\n" +
                "\t\t</path>\t\n" +
                "\t\t<circle \n" +
                "\t\t\tfill=\"#ff073a\" \n" +
                "\t\t\tr=\"2\" \n" +
                "\t\t\tcx=\"95\" \n" +
                "\t\t\tcy=\"13.965913932680017\"\t\n" +
                "\t\t\tstyle=\"opacity: 1\"\n" +
                "\t\t\t/>\n" +
                "</svg>\n" +
                "</body>\n" +
                "</html>";
        
        miniConfirmedGraph.getSettings().setJavaScriptEnabled(true);
        miniConfirmedGraph.setBackgroundColor(Color.TRANSPARENT);
        miniConfirmedGraph.setVerticalScrollBarEnabled(false);
        miniConfirmedGraph.setHorizontalScrollBarEnabled(false);
        miniConfirmedGraph.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        miniConfirmedGraph.loadDataWithBaseURL(null, miniConfirm, "text/html", "UTF-8", null);

        String miniActive = "<html>\n" +
                "<body>\n" +
                "\t<svg width=\"150\" height=\"200\">\n" +
                "\t\t<path \n" +
                "\t\t\tfill=\"none\" \n" +
                "\t\t\tstroke=\"#007bff99\" \n" +
                "\t\t\tstroke-width=\"2.5\"\n" +
                "\t\t\ttransform=\"scale(1,1) translate(0 -10)\"\n" +
                "\t\t\td=\"M5,39.145291861951435C6.5,39.69556881124841,8,40.24584576054537,9.5,40.24584576054537C11,40.24584576054537,12.5,39.53898593949723,14,38.33702599062633C15.5,37.13506604175543,17,33.03408606731998,18.5,33.03408606731998C20,33.03408606731998,21.5,37.31898878000283,23,37.43033659991478C24.5,37.54168441982673,26,37.59735832978271,27.5,37.59735832978271C29,37.59735832978271,30.5,36.11802300809544,32,35.95696634000852C33.5,35.7959096719216,35,35.75117170856412,36.5,35.71538133787814C38,35.67959096719216,39.5,35.69748615253515,41,35.66169578184917C42.5,35.62590541116319,44,35.21729867916489,45.5,35.21729867916489C47,35.21729867916489,48.5,37.317000426075836,50,37.317000426075836C51.5,37.317000426075836,53.00000000000001,35.2023860247124,54.50000000000001,35.2023860247124C56.00000000000001,35.2023860247124,57.5,36.016616957818485,59,36.016616957818485C60.5,36.016616957818485,62,34.30762675756284,63.5,34.30762675756284C65,34.30762675756284,66.5,34.55219429058372,68,34.75798892202812C69.5,34.96378355347252,71,35.54239454622923,72.5,35.54239454622923C74,35.54239454622923,75.5,10,77,10C78.5,10,80,32.16616957818491,81.5,32.16616957818491C83,32.16616957818491,84.5,30.30208777162335,86,30.30208777162335C87.5,30.30208777162335,89,33.391989774179805,90.5,33.391989774179805C92,33.391989774179805,93.5,32.43907115466553,95,31.486152535151255\" \n" +
                "\t\t\tstroke-dasharray=\"139.21029663085938\" \n" +
                "\t\t\tstroke-dashoffset=\"0\">\n" +
                "\t\t\t<animate attributeName=\"stroke-dashoffset\" values=\"139.21029663085938;0\" dur=\"2s\" repeatCount=\"once\" />\n" +
                "\t\t</path>\n" +
                "\t\t<circle \n" +
                "\t\t\tfill=\"#007bff\" \n" +
                "\t\t\tr=\"2.5\" \n" +
                "\t\t\tcx=\"95\" \n" +
                "\t\t\tcy=\"22.486152535151255\" \n" +
                "\t\t\tstyle=\"opacity: 1;\">\n" +
                "\t\t</circle>\n" +
                "\t</svg>\n" +
                "</body>\n" +
                "</html>";

        miniActiveGraph.getSettings().setJavaScriptEnabled(true);
        miniActiveGraph.setBackgroundColor(Color.TRANSPARENT);
        miniActiveGraph.setVerticalScrollBarEnabled(false);
        miniActiveGraph.setHorizontalScrollBarEnabled(false);
        miniActiveGraph.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        miniActiveGraph.loadDataWithBaseURL(null, miniActive, "text/html", "UTF-8", null);

        String miniRecovered = "<html>\n" +
                "<body>\n" +
                "\t<svg width=\"150\" height=\"200\">\n" +
                "\t\t<path \n" +
                "\t\t\tfill=\"none\" \n" +
                "\t\t\tstroke=\"#28a74599\" \n" +
                "\t\t\tstroke-width=\"2.5\"\n" +
                "\t\t\ttransform=\"scale(1,1) translate(0 -10)\"\n" +
                "\t\t\td=\"M5,39.145291861951435C6.5,39.69556881124841,8,40.24584576054537,9.5,40.24584576054537C11,40.24584576054537,12.5,39.53898593949723,14,38.33702599062633C15.5,37.13506604175543,17,33.03408606731998,18.5,33.03408606731998C20,33.03408606731998,21.5,37.31898878000283,23,37.43033659991478C24.5,37.54168441982673,26,37.59735832978271,27.5,37.59735832978271C29,37.59735832978271,30.5,36.11802300809544,32,35.95696634000852C33.5,35.7959096719216,35,35.75117170856412,36.5,35.71538133787814C38,35.67959096719216,39.5,35.69748615253515,41,35.66169578184917C42.5,35.62590541116319,44,35.21729867916489,45.5,35.21729867916489C47,35.21729867916489,48.5,37.317000426075836,50,37.317000426075836C51.5,37.317000426075836,53.00000000000001,35.2023860247124,54.50000000000001,35.2023860247124C56.00000000000001,35.2023860247124,57.5,36.016616957818485,59,36.016616957818485C60.5,36.016616957818485,62,34.30762675756284,63.5,34.30762675756284C65,34.30762675756284,66.5,34.55219429058372,68,34.75798892202812C69.5,34.96378355347252,71,35.54239454622923,72.5,35.54239454622923C74,35.54239454622923,75.5,10,77,10C78.5,10,80,32.16616957818491,81.5,32.16616957818491C83,32.16616957818491,84.5,30.30208777162335,86,30.30208777162335C87.5,30.30208777162335,89,33.391989774179805,90.5,33.391989774179805C92,33.391989774179805,93.5,32.43907115466553,95,31.486152535151255\" \n" +
                "\t\t\tstroke-dasharray=\"139.21029663085938\" \n" +
                "\t\t\tstroke-dashoffset=\"0\">\n" +
                "\t\t\t<animate attributeName=\"stroke-dashoffset\" values=\"139.21029663085938;0\" dur=\"2s\" repeatCount=\"once\" />\n" +
                "\t\t</path>\n" +
                "\t\t<circle \n" +
                "\t\t\tfill=\"#28a745\" \n" +
                "\t\t\tr=\"2.5\" \n" +
                "\t\t\tcx=\"95\" \n" +
                "\t\t\tcy=\"22.486152535151255\" \n" +
                "\t\t\tstyle=\"opacity: 1;\">\n" +
                "\t\t</circle>\n" +
                "\t</svg>\n" +
                "</body>\n" +
                "</html>";

        miniRecoveredGraph.getSettings().setJavaScriptEnabled(true);
        miniRecoveredGraph.setBackgroundColor(Color.TRANSPARENT);
        miniRecoveredGraph.setVerticalScrollBarEnabled(false);
        miniRecoveredGraph.setHorizontalScrollBarEnabled(false);
        miniRecoveredGraph.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        miniRecoveredGraph.loadDataWithBaseURL(null, miniRecovered, "text/html", "UTF-8", null);

        String miniDeceased = "<html>\n" +
                "<body>\n" +
                "\t<svg width=\"150\" height=\"200\">\n" +
                "\t\t<path \n" +
                "\t\t\tid=\"my-path\"\n" +
                "\t\t\tfill=\"none\" \n" +
                "\t\t\tstroke=\"#8ca191\" \n" +
                "\t\t\tstroke-width=\"2.5\"\t\n" +
                "\t\t\ttranslate\n" +
                "\t\t\ttransform=\"scale(1,2) translate(0 -15)\"\n" +
                "\t\t\td=\"M5,34.37622496804431C6.5,34.238282914358756,8,34.1003408606732,9.5,33.88708990200256C11,33.673838943331916,12.5,33.096719216020446,14,33.096719216020446C15.5,33.096719216020446,17,33.64252236898168,18.5,33.64252236898168C20,33.64252236898168,21.5,31.208777162334886,23,30.701746910950146C24.5,30.194716659565405,26,29.941201533873034,27.5,29.941201533873034C29,29.941201533873034,30.5,31.1968470387729,32,31.1968470387729C33.5,31.1968470387729,35,26.645504899872172,36.5,26.645504899872172C38,26.645504899872172,39.5,27.93992330634853,41,27.93992330634853C42.5,27.93992330634853,44,27.44184064763528,45.5,27.036216446527483C47,26.630592245419685,48.5,25.762675756284622,50,25.50617809970175C51.5,25.249680443118876,53.00000000000001,25.377929271410313,54.50000000000001,25.12143161482744C56.00000000000001,24.864933958244567,57.5,23.791222837665103,59,23.791222837665103C60.5,23.791222837665103,62,25.271552336315864,63.5,25.870046868342566C65,26.46854140036927,66.5,27.38219002982531,68,27.38219002982531C69.5,27.38219002982531,71,23.4044879988638,72.5,23.388581167447807C74,23.372674336031814,75.5,23.380627751739812,77,23.36472092032382C78.5,23.348814088907826,80,21.177531600624913,81.5,20.728163613123137C83,20.27879562562136,84.5,20.377716233489558,86,20.05411163187047C87.5,19.73050703025138,89,18.78653600340861,90.5,18.78653600340861C92,18.78653600340861,93.5,20.376224968044312,95,21.965913932680017\" stroke-dasharray=\"98.95734405517578\" stroke-dashoffset=\"0\">\n" +
                "\t\t\t<animate attributeName=\"stroke-dashoffset\" values=\"98.95734405517578;0\" dur=\"2s\" repeatCount=\"once\" />\n" +
                "\t\t</path>\t\n" +
                "\t\t<circle \n" +
                "\t\t\tfill=\"#454746\" \n" +
                "\t\t\tr=\"2\" \n" +
                "\t\t\tcx=\"95\" \n" +
                "\t\t\tcy=\"13.965913932680017\"\t\n" +
                "\t\t\tstyle=\"opacity: 1\"\n" +
                "\t\t\t/>\n" +
                "</svg>\n" +
                "</body>\n" +
                "</html>";

        miniDeceasedGraph.getSettings().setJavaScriptEnabled(true);
        miniDeceasedGraph.setBackgroundColor(Color.TRANSPARENT);
        miniDeceasedGraph.setVerticalScrollBarEnabled(false);
        miniDeceasedGraph.setHorizontalScrollBarEnabled(false);
        miniDeceasedGraph.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        miniDeceasedGraph.loadDataWithBaseURL(null, miniDeceased, "text/html", "UTF-8", null);

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
