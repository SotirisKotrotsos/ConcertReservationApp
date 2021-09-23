package com.example.concertreservationapplication.daomemory;

import com.example.concertreservationapplication.domain.*;

import java.util.ArrayList;
import java.util.List;

import com.example.concertreservationapplication.dao.TicketDAO;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class TicketDAOMemory implements TicketDAO {

    protected static List<Ticket> ticketsList =  new ArrayList<>();

    @Override
    public Ticket find(long ticket_number) {
        for(Ticket ticket: ticketsList){
            if (ticket.getTicket_number() == ticket_number){
                return ticket;
            }
        }
        return null;
    }

    @Override
    public void save(Ticket ticket) {
        if (!ticketsList.contains(ticket)){
            ticketsList.add(ticket);
        }
    }

    @Override
    public void delete(Ticket ticket) {
        ticketsList.remove(ticket);
    }

    @Override
    public List<Ticket> findAll() {
        return new ArrayList<Ticket>(ticketsList);
    }
}
