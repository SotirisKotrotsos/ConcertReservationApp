package com.example.concertreservationapplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Calendar;
import static org.junit.Assert.*;
import com.example.concertreservationapplication.domain.*;

public class ConcertTicketsComparatorTest {
    private Concert concert,concert1;
    private Consumer consumer;
    Calendar cl = Calendar.getInstance();
    Calendar cl1 = Calendar.getInstance();

    @Before
    public void setUp() throws Exception {
        cl1.set(2021, 10, 1);
        cl.set(2021, 6, 1);
        concert = new Concert("Mazw oso zw",cl,"katrakion","Sunaulia gia ton mazw",new Contact("692222222","osozw@mazw.gr"),1,1,10);
        concert1 = new Concert("Nikos vertis",cl1,"lykavitos","thelw na me noiwseis",new Contact("691111111","nikos@vertis.gr"),1,1,20);
        consumer = new Consumer("sotiris", "kotrotsos", new Contact("695555555", "sot@gmail.com"));

        concert1.reservationTicket(consumer, "arena", true);
        concert1.reservationTicket(consumer, "grandstand", true);
        concert.reservationTicket(consumer, "arena", true);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void compare() {
        ConcertTicketsComparator c1 = new ConcertTicketsComparator();
        assertEquals(1,c1.compare(concert,concert1));
    }
}