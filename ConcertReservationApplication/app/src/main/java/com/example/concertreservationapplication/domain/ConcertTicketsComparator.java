package com.example.concertreservationapplication.domain;

import java.util.Comparator;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class ConcertTicketsComparator implements Comparator<Concert> {

    /**
     * custom comparator for concerts to short them by total sold tickets
     * @param c1
     * @param c2
     * @return
     */
    @Override
    public int compare(Concert c1, Concert c2) {
        if(c1.totalTicketsSold() > c2.totalTicketsSold()) return -1;
        else if (c1.totalTicketsSold() < c2.totalTicketsSold()) return 1;
        else return 0;
    }
}
