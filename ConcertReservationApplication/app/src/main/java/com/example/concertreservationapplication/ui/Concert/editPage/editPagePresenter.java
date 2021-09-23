package com.example.concertreservationapplication.ui.Concert.editPage;

import com.example.concertreservationapplication.domain.Concert;
import com.example.concertreservationapplication.daomemory.ConcertDAOMemory;
import java.util.List;

/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class editPagePresenter {

    private editPageView view;
    private ConcertDAOMemory  concertDAOMemory;
    private List<Concert> concertsList;

    /**
     * presenter's constructor
     * @param view
     * @param concertDAOMemory
     */
    public editPagePresenter(editPageView view, ConcertDAOMemory concertDAOMemory){
        this.view = view;
        this.concertDAOMemory = concertDAOMemory;
        concertsList = concertDAOMemory.findAll();

    }

    /**
     * move to chosen concert
     * @param concert
     */
    public void onClickConcert(String concert){view.clickConcert(concert);}

    /**
     * returns String array with concerts titles
     * @return
     */
    public String[] concertsName(){

        int length = concertsList.size();
        String[] arr = new String[length];
        for(int i =0;i<length;i++){
            arr[i] = concertsList.get(i).getTitle();
        }
        return arr;
    }
}
