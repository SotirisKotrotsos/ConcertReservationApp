package com.example.concertreservationapplication.ui.ticket.myTicketsPage;

import com.example.concertreservationapplication.domain.Consumer;
import com.example.concertreservationapplication.domain.Ticket;
import java.util.ArrayList;
import com.example.concertreservationapplication.daomemory.ConsumerDAOMemory;

/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class myTicketsPagePresenter {

    private myTicketsPageView view;
    private ConsumerDAOMemory consumerDAOMemory;
    private Consumer ticketsList;
    ArrayList<Ticket> listWithTickets;


    /**
     * presenter's constructor
     * @param view
     * @param tickets
     */
    public myTicketsPagePresenter(myTicketsPageView view, ConsumerDAOMemory tickets){
        this.view = view;
        this.consumerDAOMemory = tickets;
        this.ticketsList = tickets.find(view.getphone());
        //this.listWithTickets = ticketsList.getBooked();
//        System.out.println("///////"+ticketsList.getBooked().size());
        try {
            this.listWithTickets = ticketsList.getBooked();
        }
        catch (Exception e){
            view.toStartPage();
        }


    }

    /**
     * go to activity with selected ticket
     * @param concertTitle
     * @param getphone
     */
    void onSelectedTicket(String concertTitle, String getphone){
        view.selectedTicketPage(concertTitle,getphone);
    }

    /**
     * return String array with tickets
     * @return
     */
    public String[] getTicketList(){
        int length = listWithTickets.size();
        System.out.println("+++++++"+length);
        String[] arr = new String[length];
        for(int i =0;i<length;i++){

            arr[i] = listWithTickets.get(i).getConcert().getTitle();
            System.out.println(arr[i]);
        }
        return arr;
    }

}
