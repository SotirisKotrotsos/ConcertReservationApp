package com.example.concertreservationapplication.ui.ticket.selectedConcertPage;

import com.example.concertreservationapplication.daomemory.ConcertDAOMemory;
import com.example.concertreservationapplication.domain.Concert;
import java.util.Calendar;

/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class selectedConcertPagePresenter {
    private selectedConcertPageView view;
    private ConcertDAOMemory concert;
    private Concert attachedConcert;

    public selectedConcertPagePresenter(selectedConcertPageView view,ConcertDAOMemory concert){
        this.view = view;
        this.concert = concert;

        attachedConcert = concert.find(view.getTitleConcert());

        Calendar cl = attachedConcert.getCalendar();
        int year = cl.get(Calendar.YEAR);
        int day = cl.get(Calendar.DAY_OF_MONTH);
        int month = cl.get(Calendar.MONTH);

        view.setConcertTitle(view.getTitleConcert());
        view.setConcertPrice(String.valueOf(attachedConcert.getPrice_of_grandstand_ticket()));
        view.setConcertLocation(attachedConcert.getLocation());
        view.setConcertDate(year+"/"+month+"/"+day);
        view.setConcertDescription(attachedConcert.getDescription());

    }

    public void onReverseTicketPage(String title){
        view.reservePage(title);
    }

    public String getConcertTitle(){
        return attachedConcert.getTitle();
    }
}
