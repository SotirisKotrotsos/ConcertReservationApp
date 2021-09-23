package com.example.concertreservationapplication;

import com.example.concertreservationapplication.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import static org.junit.Assert.*;

public class ConcertTest {
    private Consumer consumer, consumer1, consumer2;
    private Concert concert, concert1;
    private Ticket ticket, ticket1;
    Calendar cl = Calendar.getInstance();
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


/**
     * Arxikopoioume ta dedomena mas dhladh concert, consumer, ticket, date.
     * Ta antikeimena tis concert exoun apo 1 ticket se ka8e kathgoria
     */

    @Before
    public void setUp(){
        cl.set(2021,10,7);
        float price = 10;
        concert = new Concert("Mazw oso zw",cl,"katrakion","Sunaulia gia ton mazw",new Contact("692222222","osozw@mazw.gr"),1,1,price);
        concert1 = new Concert("Nikos vertis",cl,"lykavitos","thelw na me noiwseis",new Contact("691111111","nikos@vertis.gr"),1,1,price);
        ticket = new Ticket("grandstand", 1235, consumer,false,concert);
        ticket1 = new Ticket("arena", 1234, consumer, false,concert);
        consumer = new Consumer("marios", "raftopoulos", new Contact("6944444444", "raf@gmail.com"));
        consumer1 = new Consumer("sotiris", "kotrotsos", new Contact("695555555", "sot@gmail.com"));
        consumer2 = new Consumer("sotiris", "kotrotsos", new Contact("695555555", "sot@gmail.com"));
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown(){
        System.setOut(standardOut);
    }


 @Test
    public void reservationTicketTest(){
        concert.reservationTicket(consumer,"arena",true);
        assertEquals(1,concert.getNum_arena());
        concert1.reservationTicket(consumer,"grandstand",true);
        assertEquals(1,concert1.getNum_grand());
        concert.reservationTicket(consumer,"arena",true);
        assertEquals("arena tickets sold out!",outputStreamCaptor.toString());
        concert.reservationTicket(consumer2,"grandstand",false);
        assertEquals(1,concert.getNum_grand());

    }
    @Test
    public void checkCategoryAvailabilityTest(){
        concert.raiseNum_grand();
        assertEquals(false,concert.checkCategoryAvailability("grandstand"));
        assertEquals(true,concert.checkCategoryAvailability("arena"));
        concert.raiseNum_arena();
        assertEquals(false,concert.checkCategoryAvailability("arena"));

    }
    @Test
    public void isFullTest(){

        concert.reservationTicket(consumer, "arena", true);

        concert.reservationTicket(consumer, "grandstand", true);
        assertEquals(true,concert.isFull());
    }
    @Test
    public void totalTicketSoldTest(){
        concert.reservationTicket(consumer,"grandstand",true);
        concert.reservationTicket(consumer1,"arena",true);


        assertEquals(2,concert.totalTicketsSold());
    }
    @Test
    public void totalRevenueTest(){
        concert.reservationTicket(consumer,"grandstand",true);
        concert.reservationTicket(consumer1,"arena",true);
        assertEquals(30,concert.totalRevenue(),0.0002);
    }
    @Test
    public void equalsTest(){
        assertEquals(false,concert.equals(concert1));
    }
    @Test
    public void raiseNum_arenaTest(){
        concert.raiseNum_arena();
        assertEquals(1,concert.getNum_arena());
    }
    @Test
    public void raiseNum_grandTest(){
        concert.raiseNum_grand();
        assertEquals(1,concert.getNum_grand());
    }
    @Test
    public void setNumber_of_arena_ticketsTest(){
        concert.setNumber_of_arena_tickets(2);
        assertEquals(2,concert.getNumber_of_arena_tickets());
    }
    @Test
    public void setNumber_of_grandstand_ticketsTest(){
        concert.setNumber_of_grandstand_tickets(3);
        assertEquals(3,concert.getNumber_of_grandstand_tickets());
    }
    @Test
    public void setPrice_of_grandstand_ticket(){
        concert.setPrice_of_grandstand_ticket((float) 12.5);
        assertEquals(12.5,concert.getPrice_of_grandstand_ticket(),0.0002);
    }
    @Test
    public void cancelConcertTest(){
        concert.reservationTicket(consumer,"arena",true);
        concert.cancelConcert();
        assertEquals(0,concert.getNum_arena());
        assertEquals(0,concert.getNum_grand());
        assertEquals(true,concert.isEmpty());
    }
    @Test
    public void isEmptyTest(){
        concert.reservationTicket(consumer,"arena",true);
        assertEquals(false,concert.isEmpty());
    }
}

