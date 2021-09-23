package com.example.concertreservationapplication.daomemory;

import com.example.concertreservationapplication.domain.*;

import java.util.List;

import com.example.concertreservationapplication.dao.ConsumerDAO;
import com.example.concertreservationapplication.dao.Initializer;
import com.example.concertreservationapplication.dao.TicketDAO;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class MemoryInitializer extends Initializer {

    @Override
    protected void ereaseData() {
        List<Concert> allConcerts = getConcertDAO().findAll();
        for (Concert concert : allConcerts) {
            getConcertDAO().delete(concert);
        }
        List<Consumer> allConsumers = getConsumerDAO().findAll();
        for (Consumer consumer : allConsumers) {
            getConsumerDAO().delete(consumer);
        }
        List<Ticket> allTickets = getTicketDAO().findAll();
        for (Ticket ticket : allTickets) {
            getTicketDAO().delete(ticket);
        }
    }

    @Override
    protected ConcertDAOMemory getConcertDAO() {
        return new ConcertDAOMemory();
    }

    @Override
    protected ConsumerDAO getConsumerDAO() {
        return new ConsumerDAOMemory();
    }

    @Override
    protected TicketDAO getTicketDAO() {
        return new TicketDAOMemory();
    }
}
