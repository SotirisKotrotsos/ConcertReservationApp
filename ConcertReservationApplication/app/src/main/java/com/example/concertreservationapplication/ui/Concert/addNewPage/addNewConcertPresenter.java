package com.example.concertreservationapplication.ui.Concert.addNewPage;

import com.example.concertreservationapplication.domain.*;

import com.example.concertreservationapplication.daomemory.ConcertDAOMemory;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class addNewConcertPresenter {

    private addNewConcertView view;
    private ConcertDAOMemory concertDAO;

    /**
     * constructor of presenter
     * @param view
     * @param concertDAO
     */
    addNewConcertPresenter(addNewConcertView view, ConcertDAOMemory concertDAO){
        this.view = view;
        this.concertDAO = concertDAO;
    }


    /**
     * getting values of EditText and set them on Concert instance
     */
    public void onAddConcert(){
        Concert concert = new Concert();

        concert.setTitle(view.getConcertTitle());
        concert.setCalendar(view.getConcertDate());
        concert.setLocation(view.getLocation());
        concert.setContact(new Contact(view.getPhoneNumber(), view.getEmailAddress()));
        concert.setNumber_of_arena_tickets(view.getNumberOfArenaTickets());
        concert.setNumber_of_grandstand_tickets(view.getNumberOfGrandStandTickets());
        concert.setPrice_of_grandstand_ticket(view.getPriceOfGrandstand());
        concert.setDescription(view.getDescription());

        concertDAO.save(concert);
        view.startPage();
    }

}
