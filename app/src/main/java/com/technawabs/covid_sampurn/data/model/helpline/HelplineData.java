package com.technawabs.covid_sampurn.data.model.helpline;

import java.util.ArrayList;
import java.util.List;

public class HelplineData {

    private String helplineNumber = "+91-11-23978046";
    private String tollFreeNumber = "1075";
    private String helplineEmail = "ncov2019@gov.in";
    private List<StateHelpline> helplineDataList = new ArrayList<>();

    public String getHelplineNumber() {
        return helplineNumber;
    }

    public void setHelplineNumber(String helplineNumber) {
        this.helplineNumber = helplineNumber;
    }

    public String getTollFreeNumber() {
        return tollFreeNumber;
    }

    public void setTollFreeNumber(String tollFreeNumber) {
        this.tollFreeNumber = tollFreeNumber;
    }

    public String getHelplineEmail() {
        return helplineEmail;
    }

    public void setHelplineEmail(String helplineEmail) {
        this.helplineEmail = helplineEmail;
    }

    public List<StateHelpline> getHelplineDataList() {
        StateHelpline helpline = new StateHelpline();
        helpline.setName("Helpline Number");
        helpline.setHelplineNumber("+91-11-23978046");
        helplineDataList.add(helpline);
        StateHelpline tollFree = new StateHelpline();
        tollFree.setName("Toll Free Number");
        tollFree.setHelplineNumber("1075");
        helplineDataList.add(tollFree);
        StateHelpline helplineEmail = new StateHelpline();
        helplineEmail.setName("Helpline Email");
        helplineEmail.setHelplineNumber("ncov2019@gov.in");
        helplineDataList.add(helplineEmail);
//        states
        StateHelpline state = new StateHelpline();
        state.setName("Andhra Pradesh");
        state.setHelplineNumber("08662410978");
        helplineDataList.add(state);
        StateHelpline state2 = new StateHelpline();
        state2.setName("Arunachal Pradesh");
        state2.setHelplineNumber("9436055743");
        helplineDataList.add(state2);
        StateHelpline state3 = new StateHelpline();
        state3.setName("Assam");
        state3.setHelplineNumber("6913347770");
        helplineDataList.add(state3);
        StateHelpline state4 = new StateHelpline();
        state4.setName("Bihar");
        state4.setHelplineNumber("104");
        helplineDataList.add(state4);
        StateHelpline state5 = new StateHelpline();
        state5.setName("Chhattisgarh");
        state5.setHelplineNumber("104");
        helplineDataList.add(state5);
        StateHelpline state6 = new StateHelpline();
        state6.setName("Goa");
        state6.setHelplineNumber("104");
        helplineDataList.add(state6);
        StateHelpline state7 = new StateHelpline();
        state7.setName("Gujarat");
        state7.setHelplineNumber("104");
        helplineDataList.add(state7);
        StateHelpline state8 = new StateHelpline();
        state8.setName("Haryana");
        state8.setHelplineNumber("8558893911");
        helplineDataList.add(state8);
        StateHelpline state9 = new StateHelpline();
        state9.setName("Himachal Pradesh ");
        state9.setHelplineNumber("104");
        helplineDataList.add(state9);
        StateHelpline state10 = new StateHelpline();
        state10.setName("Jharkhand");
        state10.setHelplineNumber("104");
        helplineDataList.add(state10);
        StateHelpline state11 = new StateHelpline();
        state11.setName("Karnataka");
        state11.setHelplineNumber("104");
        helplineDataList.add(state11);
        StateHelpline state12 = new StateHelpline();
        state12.setName("Kerala");
        state12.setHelplineNumber("04712552056");
        helplineDataList.add(state12);
        StateHelpline state13 = new StateHelpline();
        state13.setName("Madhya Pradesh");
        state13.setHelplineNumber("104");
        helplineDataList.add(state13);
        StateHelpline state14 = new StateHelpline();
        state14.setName("Maharashtra");
        state14.setHelplineNumber("02026127394");
        helplineDataList.add(state14);
        StateHelpline state15 = new StateHelpline();
        state15.setName("Manipur");
        state15.setHelplineNumber("3852411668");
        helplineDataList.add(state15);
        StateHelpline state16 = new StateHelpline();
        state16.setName("Meghalaya");
        state16.setHelplineNumber("108");
        helplineDataList.add(state16);
        StateHelpline state17 = new StateHelpline();
        state17.setName("Mizoram");
        state17.setHelplineNumber("102");
        helplineDataList.add(state17);
        StateHelpline state18 = new StateHelpline();
        state18.setName("Nagaland");
        state18.setHelplineNumber("7005539653");
        helplineDataList.add(state18);
        StateHelpline state19 = new StateHelpline();
        state19.setName("Odisha");
        state19.setHelplineNumber("9439994859");
        helplineDataList.add(state19);
        StateHelpline state20 = new StateHelpline();
        state20.setName("Punjab");
        state20.setHelplineNumber("104");
        helplineDataList.add(state20);
        StateHelpline state21 = new StateHelpline();
        state21.setName("Rajasthan");
        state21.setHelplineNumber("01412225624");
        helplineDataList.add(state21);
        StateHelpline state22 = new StateHelpline();
        state22.setName("Sikkim");
        state22.setHelplineNumber("104");
        helplineDataList.add(state22);
        StateHelpline state23 = new StateHelpline();
        state23.setName("Tamil Nadu");
        state23.setHelplineNumber("04429510500");
        helplineDataList.add(state23);
        StateHelpline state24 = new StateHelpline();
        state24.setName("Telangana");
        state24.setHelplineNumber("104");
        helplineDataList.add(state24);
        StateHelpline state25 = new StateHelpline();
        state25.setName("Tripura");
        state25.setHelplineNumber("03812315879");
        helplineDataList.add(state25);
        StateHelpline state26 = new StateHelpline();
        state26.setName("Uttarakhand");
        state26.setHelplineNumber("104");
        helplineDataList.add(state26);
        StateHelpline state27 = new StateHelpline();
        state27.setName("Uttar Pradesh");
        state27.setHelplineNumber("18001805145");
        helplineDataList.add(state27);
        StateHelpline state28 = new StateHelpline();
        state28.setName("West Bengal");
        state28.setHelplineNumber("1800313444222");
        helplineDataList.add(state28);
//        ut
        StateHelpline stateUT = new StateHelpline();
        stateUT.setName("Andaman and Nicobar Islands");
        stateUT.setHelplineNumber("03192232102");
        helplineDataList.add(stateUT);
        StateHelpline stateUT2 = new StateHelpline();
        stateUT2.setName("Chandigarh");
        stateUT2.setHelplineNumber("9779558282");
        helplineDataList.add(stateUT2);
        StateHelpline stateUT3 = new StateHelpline();
        stateUT3.setName("Dadra and Nagar Haveli and Daman & Diu");
        stateUT3.setHelplineNumber("104");
        helplineDataList.add(stateUT3);
        StateHelpline stateUT4 = new StateHelpline();
        stateUT4.setName("Delhi");
        stateUT4.setHelplineNumber("01122307145");
        helplineDataList.add(stateUT4);
        StateHelpline stateUT5 = new StateHelpline();
        stateUT5.setName("Jammu & Kashmir");
        stateUT5.setHelplineNumber("01912520982");
        helplineDataList.add(stateUT5);
        StateHelpline stateUT6 = new StateHelpline();
        stateUT6.setName("Ladakh");
        stateUT6.setHelplineNumber("01982256462");
        helplineDataList.add(stateUT6);
        StateHelpline stateUT7 = new StateHelpline();
        stateUT7.setName("Lakshadweep");
        stateUT7.setHelplineNumber("104");
        helplineDataList.add(stateUT7);
        StateHelpline stateUT8 = new StateHelpline();
        stateUT8.setName("Puducherry");
        stateUT8.setHelplineNumber("104");
        helplineDataList.add(stateUT8);
        return helplineDataList;
    }

    public void setHelplineDataList(List<StateHelpline> helplineDataList) {
        this.helplineDataList = helplineDataList;
    }
}
