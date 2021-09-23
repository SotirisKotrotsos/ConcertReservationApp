package com.example.concertreservationapplication.ui.ticket.selectedTicketPage;

import com.example.concertreservationapplication.domain.*;
import java.util.ArrayList;
import java.util.List;
import com.example.concertreservationapplication.daomemory.ConcertDAOMemory;
import com.example.concertreservationapplication.daomemory.ConsumerDAOMemory;


public class selectedTicketPagePresenter {
    private selectedTicketPageView view;
    private ConsumerDAOMemory consumerDAOMemory;
    private ConcertDAOMemory concertDAOMemory;
    private Ticket attachedTicket;
    private List<Consumer> consumerList;
    private Ticket selectedTicket;
    ArrayList<Ticket> listWithTickets;
    private String titleOfConcert;
    private String phoneOfConcumer;
    private Concert concert;
    private Consumer consumer;

    public selectedTicketPagePresenter(selectedTicketPageView view, ConsumerDAOMemory consumerDAOMemory, ConcertDAOMemory concertDAOMemory) {
        this.view=view;
        this.consumerDAOMemory = consumerDAOMemory;
        this.concertDAOMemory = concertDAOMemory;
       /* consumerList = consumerDAOMemory.findAll();
        for(int i = 0;i<consumerList.size();i++){
            listWithTickets = consumerList.get(i).getBooked();
        }*/
        concert = concertDAOMemory.find(view.getTitleConcert());
        consumer = consumerDAOMemory.find(view.getphone());
        listWithTickets = consumer.getBooked();
        for(int i=0;i<listWithTickets.size();i++){
            if(listWithTickets.get(i).getConcert().getTitle().equals(view.getTitleConcert())){
                attachedTicket = listWithTickets.get(i);
            }
        }


        view.setFirstName(consumer.getFirst_name());
        view.setLastName(consumer.getLast_name());
        view.setConcertLocation(concert.getLocation());
        view.setConcertTitle(concert.getTitle());
        view.setTicketCategory(attachedTicket.getCategory());

        this.titleOfConcert = view.getTitleConcert();
        this.phoneOfConcumer = view.getphone();
    }
    public String getTicketTitle() {
        return attachedTicket.getConcert().getTitle();
    }

    public void cancelTicket(String titleOfSelectedTicket) {
        System.out.println("edwwwwwww"+titleOfConcert);
        Concert concertDelete = concertDAOMemory.find(titleOfConcert);
        Concert tempConcert = concertDAOMemory.delete(concertDelete);

        Consumer consumerDelete = consumerDAOMemory.find(phoneOfConcumer);
        Consumer tempConsumer = consumerDAOMemory.delete(consumerDelete);

        for(int i=0;i<listWithTickets.size();i++){
            if(listWithTickets.get(i).getConcert().getTitle().equals(titleOfSelectedTicket)){
                long numberOfTicket = attachedTicket.getTicket_number();
                selectedTicket = listWithTickets.get(i);
            }
        }

        selectedTicket.cancelPurchaseTicket();
        //tempConcert.cancelOneTicket(selectedTicket);
        tempConsumer.cancelTicket(selectedTicket);

        concertDAOMemory.save(tempConcert);
        consumerDAOMemory.save(tempConsumer);
        //ticket.delete(selectedTicket);
        view.tostartPage();
    }


}
