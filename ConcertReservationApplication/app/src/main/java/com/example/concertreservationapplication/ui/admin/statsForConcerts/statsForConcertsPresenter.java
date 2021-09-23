package com.example.concertreservationapplication.ui.admin.statsForConcerts;

import com.example.concertreservationapplication.domain.Admin;
import com.example.concertreservationapplication.domain.Concert;
import java.util.ArrayList;
import java.util.Calendar;
import com.example.concertreservationapplication.daomemory.ConcertDAOMemory;

/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class statsForConcertsPresenter {
    statsForConcertsView view;
    ConcertDAOMemory concerts;
    ArrayList<Concert> concertList;
    Calendar calendar = Calendar.getInstance();
    String year;

    /**
     * constructor of presenter
     * @param view
     * @param concerts
     */
    public statsForConcertsPresenter(statsForConcertsView view, ConcertDAOMemory concerts) {
        this.view = view;
        this.concerts = concerts;
        concertList = (ArrayList<Concert>) concerts.findAll();
        year = view.getYear();

    }

    /**
     * return String array with shorted concerts by sold tickets
     * @return
     */
    public String[] getConcertAndTicketList(){
        int year1 = Integer.parseInt(year);
        System.out.println(year1);
        Admin stats2 = new Admin(concertList, year1);
        ArrayList<Concert> concerts1 = stats2.showConcertsBySoldTickets();
        String [] stats = new String[concerts1.size()];
        //System.out.println(concerts1.size());
        for(int i=0; i<concerts1.size(); i++){
            Concert con = concerts1.get(i);
            stats[i] = "Title: " + con.getTitle() +"\nTickets sold:  " + (con.getNum_arena() + con.getNum_grand());
        }
        return stats;
    }
}
