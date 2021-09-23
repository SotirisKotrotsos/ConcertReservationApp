package com.example.concertreservationapplication.dao;

import com.example.concertreservationapplication.domain.*;

import java.util.Calendar;

/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public abstract class Initializer {

    protected abstract void ereaseData();

    public void prepareData(){
        ereaseData();


        Calendar clMazwnakis = Calendar.getInstance(), clVertis =  Calendar.getInstance();
        clMazwnakis.set(2021,7,1);
        clVertis.set(2021, 7, 10);

        Concert mazwnakis = new Concert("Mazw oso zw",clMazwnakis,"katrakion","Sunaulia gia ton mazw",new Contact("6912345677","osozw@mazw.gr"),15,15,10);
        Concert vertis = new Concert("Nikos vertis",clVertis,"lykavitos","thelw na me noiwseis",new Contact("691111111","nikos@vertis.gr"),10,20,20);

        Consumer marios = new Consumer("Marios", "Raf", new Contact("6912345678", "marios@email.com"));
        Consumer george = new Consumer("Giorgos", "Kar", new Contact("6912345688", "george@email.com"));
        Consumer sotiris = new Consumer("Sotiris", "Kot", new Contact("6912345699", "sotiris@email.com"));

        mazwnakis.reservationTicket(marios,"arena", true);
        mazwnakis.reservationTicket(sotiris,"grandstand", true);
        mazwnakis.reservationTicket(george,"arena", false);

        vertis.reservationTicket(marios, "arena", true);
        vertis.reservationTicket(marios, "arena", false);
        vertis.reservationTicket(marios, "grandstand", true);

        getConcertDAO().save(mazwnakis);
        getConcertDAO().save(vertis);
        getConsumerDAO().save(marios);
        getConsumerDAO().save(george);
        getConsumerDAO().save(sotiris);

    }

    protected abstract ConcertDAO getConcertDAO();
    protected abstract ConsumerDAO getConsumerDAO();
    protected abstract TicketDAO getTicketDAO();
}
