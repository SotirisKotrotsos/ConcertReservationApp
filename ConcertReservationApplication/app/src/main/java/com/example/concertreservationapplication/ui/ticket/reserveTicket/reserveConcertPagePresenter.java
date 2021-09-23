package com.example.concertreservationapplication.ui.ticket.reserveTicket;

import com.example.concertreservationapplication.domain.*;
import com.example.concertreservationapplication.daomemory.ConcertDAOMemory;
import com.example.concertreservationapplication.daomemory.ConsumerDAOMemory;

/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class reserveConcertPagePresenter {
    private reserveConcertPageView view;
    private ConcertDAOMemory concertDAOMemory;
    private ConsumerDAOMemory consumerDAOMemory;
    private String title;

    /**
     * presenter's constructor
     * @param view
     * @param concertDAOMemory
     * @param consumerDAOMemory
     */
    reserveConcertPagePresenter(reserveConcertPageView view, ConcertDAOMemory concertDAOMemory, ConsumerDAOMemory consumerDAOMemory){
        this.view = view;
        this.concertDAOMemory = concertDAOMemory;
        this.consumerDAOMemory = consumerDAOMemory;
        this.title = view.getTitleConcert();

    }

    /**
     * actions when click buy
     */
    public void onBuyTicket() {
        Concert concerttmpDelete = concertDAOMemory.find(title);
        Concert concerttmp = concertDAOMemory.delete(concerttmpDelete);
        Consumer consumertmp = new Consumer(view.getFirstName(), view.getLastName(), new Contact(view.getPhoneNumber(), view.getEmail()));
        concerttmp.reservationTicket(consumertmp, view.getCategory(), true);
        concertDAOMemory.save(concerttmp);
        consumerDAOMemory.save(consumertmp);
        view.onstartPage();
    }

    /**
     * actions when click reserve
     */
    public void onReserveTicket() {
        Concert concerttmpDelete = concertDAOMemory.find(title);
        Concert concerttmp = concertDAOMemory.delete(concerttmpDelete);
        Consumer consumertmp = new Consumer(view.getFirstName(), view.getLastName(), new Contact(view.getPhoneNumber(), view.getEmail()));
        concerttmp.reservationTicket(consumertmp, view.getCategory(), false);
        concertDAOMemory.save(concerttmp);
        consumerDAOMemory.save(consumertmp);
        view.onstartPage();
    }
}
