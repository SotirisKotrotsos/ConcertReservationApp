package com.example.concertreservationapplication.ui.Concert.ediConcertPage;

import com.example.concertreservationapplication.domain.*;
import java.util.List;
import com.example.concertreservationapplication.daomemory.ConcertDAOMemory;

/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class editConcertPagePresenter {

    private editConcertPageView view;
    ConcertDAOMemory concertDAOMemory;
    List<Concert> concerts;
    String concert;

    /**
     * constructor of presenter
     * @param view
     * @param concertDAOMemory
     */
    public editConcertPagePresenter(editConcertPageView view, ConcertDAOMemory concertDAOMemory) {
        this.view = view;
        this.concertDAOMemory = concertDAOMemory;
        this.concerts = concertDAOMemory.findAll();
        this.concert = view.getSelecterdConcertTitle();
    }

    /**
     * set EditText with chosen concert values
     */
    public void onShowFields(){
        Concert temp = concertDAOMemory.find(concert);
        view.setConcertDate(temp.getCalendar());
        view.setConcertTitle(temp.getTitle());
        view.setDescription(temp.getDescription());
        view.setEmailAddress(temp.getContact().getEmail());
        view.setPhoneNumber(temp.getContact().getPhone_number());
        view.setNumberOfArenaTickets(temp.getNumber_of_arena_tickets());
        view.setNumberOfGrandStandTickets(temp.getNumber_of_grandstand_tickets());
        view.setPriceOfGrandstand(temp.getPrice_of_grandstand_ticket());

    }

    /**
     * get text from EditText and set them on concert instance
     * and save it in dao, finaly return on concertPage
     */
    public void onEditFields(){
        Concert tempDelete = concertDAOMemory.find(concert);
        Concert temp = concertDAOMemory.delete(tempDelete);

        temp.setTitle(view.getConcertTitle());
        temp.setCalendar(view.getConcertDate());
        temp.setContact(new Contact(view.getPhoneNumber(), view.getEmailAddress()));
        temp.setNumber_of_arena_tickets(view.getNumberOfArenaTickets());
        temp.setNumber_of_grandstand_tickets(view.getNumberOfGrandStandTickets());
        temp.setPrice_of_grandstand_ticket(view.getPriceOfGrandstand());
        temp.setDescription(view.getDescription());

        concertDAOMemory.save(temp);

        view.toReturnPage();
    }
}
