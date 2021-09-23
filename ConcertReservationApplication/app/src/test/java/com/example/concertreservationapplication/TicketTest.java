package com.example.concertreservationapplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.example.concertreservationapplication.domain.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.PublicKey;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class TicketTest {

    private Ticket ticket, ticket1, emptyTicket;
    private Consumer consumer;
    private Concert concert;
    float price = 10;
    Calendar cl = Calendar.getInstance();
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @Before
    public void setUp() throws Exception {
        cl.set(2021,10,7);
        concert = new Concert("Mazw oso zw",cl,"katrakion","Sunaulia gia ton mazw",new Contact("692222222","osozw@mazw.gr"),1,1,price);
        consumer = new Consumer("Marios", "Raf", new Contact("68392", "rafitida@gmail.com"));
        ticket = new Ticket("arena", 1234, consumer, false,concert);
        ticket1 = new Ticket("arena1", 1234, consumer, false, concert);
        emptyTicket = new Ticket();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(standardOut);
    }
    @Test
    public void buyTicketTest(){
        ticket.buyTicket();
        assertEquals(true, ticket.isPayed());

        ticket.buyTicket();

       assertEquals("This ticket is already payed!",outputStreamCaptor.toString());
    }
    @Test
    public void cancelPurchaseTicketTest(){
        ticket.buyTicket();
        ticket.cancelPurchaseTicket();
        assertEquals(false, ticket.isPayed());
        assertEquals(true,concert.isEmpty());
        assertEquals(false, ticket.isPayed());
    }

    @Test
    public void priceTicket(){
        assertEquals(price, ticket.getConcert().getPrice_of_grandstand_ticket(),0.0002);
    }
    @Test
    public void equalsTest(){
        assertNotSame(ticket, ticket1);
        assertSame(ticket, ticket);
    }


    @Test
    public void getCategory() {
        assertEquals("arena",ticket.getCategory());
    }

    @Test
    public void setCategory() {
        ticket.setCategory("Arena");
        assertEquals("Arena",ticket.getCategory());
    }

    @Test
    public void getTicket_number() {
        assertEquals(1234,ticket.getTicket_number());
    }

    @Test
    public void setTicket_number() {
        ticket.setTicket_number(1235);
        assertEquals(1235,ticket.getTicket_number());
    }

    @Test
    public void getTitle() {
        assertEquals("Mazw oso zw",ticket.getConcert().getTitle());
    }
    @Test
    public void testGettersSetter(){
        emptyTicket.setCategory("arena");
        emptyTicket.setConsumer(consumer);
        emptyTicket.setTicket_number(1234);
        emptyTicket.setPrice_of_grandstand_ticket(price);


        assertEquals(ticket.getCategory() ,emptyTicket.getCategory());
        assertEquals(ticket.getConsumer() ,emptyTicket.getConsumer());
        assertEquals(ticket.getTicket_number() ,emptyTicket.getTicket_number());


        emptyTicket.setCategory("grandstand");
        ticket.setCategory("grandstand");
        assertEquals(ticket.getTicket_number() ,emptyTicket.getTicket_number());
    }
}