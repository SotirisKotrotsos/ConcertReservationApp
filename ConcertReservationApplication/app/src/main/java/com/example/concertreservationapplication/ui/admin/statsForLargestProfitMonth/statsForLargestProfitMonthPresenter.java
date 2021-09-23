package com.example.concertreservationapplication.ui.admin.statsForLargestProfitMonth;

import com.example.concertreservationapplication.domain.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.example.concertreservationapplication.daomemory.ConcertDAOMemory;

public class statsForLargestProfitMonthPresenter {

     statsForLargestProfitMonthView view;
     ConcertDAOMemory concerts;
     List<Concert> concertList;
     Calendar calendar = Calendar.getInstance();
     String year;

    /**
     * constructor of presenter
     * @param view
     * @param concerts
     */
    public statsForLargestProfitMonthPresenter(statsForLargestProfitMonthView view, ConcertDAOMemory concerts) {
        this.view = view;
        this.concerts = concerts;
        concertList = concerts.findAll();
        year = view.getYear();
    }

    /**
     * return an object array with length 2, that contains one float and one int
     * @return
     */
    public Object[] getMonthAndRevenueList(){
        int inputYear = Integer.parseInt(year);
        Admin stats1 = new Admin((ArrayList<Concert>) concertList, inputYear);
        Object[] concerts2 = stats1.showMonthOfMaxRevenueOfConcerts();
        return concerts2;
    }

    /**
     * setting values on the textViews
     * @param obj
     */
    public void onSetText(Object[] obj){
        view.setText(obj);
    }

}



