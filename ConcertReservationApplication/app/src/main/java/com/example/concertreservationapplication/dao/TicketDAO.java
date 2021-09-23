package com.example.concertreservationapplication.dao;

import com.example.concertreservationapplication.domain.*;

import java.util.List;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public interface TicketDAO {

    public Ticket find(long ticket_number);
    public void save(Ticket ticket);
    public void delete(Ticket ticket);
    public List<Ticket> findAll();
}
