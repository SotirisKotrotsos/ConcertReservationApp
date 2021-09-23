package com.example.concertreservationapplication.ui.ticket.viewConcertsPage;

import com.example.concertreservationapplication.domain.Concert;
import java.util.List;
import com.example.concertreservationapplication.daomemory.ConcertDAOMemory;

/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class viewConcertsPagePresenter {

    private viewConcertsPageView view;
    private ConcertDAOMemory concertDAOMemory;
    private List<Concert> concertsList;

    /**
     * presenter's constructor
     * @param view
     * @param concerts
     */
    public viewConcertsPagePresenter(viewConcertsPageView view,ConcertDAOMemory concerts){
        this.view = view;
        this.concertDAOMemory = concerts;
        concertsList = concerts.findAll();
    }

    /**
     * move to selected concert page
     * @param concertTitle
     */
    void onSelectedConcert(String concertTitle){
        view.selectedConcertPage(concertTitle);
    }

    public String[] getConcertsList() {
        int length = concertsList.size();
        String[] arr = new String[length];
        for(int i =0;i<length;i++){
            arr[i] = concertsList.get(i).getTitle();
        }
        return arr;

    }
}
