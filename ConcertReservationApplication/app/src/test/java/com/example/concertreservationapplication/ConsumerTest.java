package com.example.concertreservationapplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;
import com.example.concertreservationapplication.domain.*;
import static org.junit.Assert.*;

public class ConsumerTest {

    Ticket ticket, ticket1;
    Consumer consumer;
    Concert concert;
    float price = 10;
    Calendar cl = Calendar.getInstance();

    @Before
    public void setUp() throws Exception {
        cl.set(2021,5,9);
        concert = new Concert("Mazw oso zw",cl,"katrakion","Sunaulia gia ton mazw",new Contact("692222222","osozw@mazw.gr"),1,1,price);
        ticket = new Ticket("arena", 1234, consumer,  false,concert);
        ticket1 = new Ticket("arena1", 1234, consumer, false,concert);
        consumer = new Consumer("marios", "raftopoulos", new Contact("6944444444", "raf@gmail.com"));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testReserveTicket() {
        assertEquals(true, consumer.reserveTicket(ticket));

        assertEquals(false, consumer.reserveTicket(ticket));

        assertEquals(true, consumer.reserveTicket(ticket1));
    }

    @Test
    public void testPurchaseTicket() {
        assertEquals(!ticket.isPayed(), consumer.purchaseTicket(ticket));

        consumer.reserveTicket(ticket1);
        assertEquals(!ticket1.isPayed(), consumer.purchaseTicket(ticket1));

        assertEquals(false, consumer.purchaseTicket(ticket1));
    }

    @Test
    public void testCancelTicket() {

        assertEquals(false, consumer.cancelTicket(ticket));

        ArrayList<Ticket> tickets = consumer.getBooked();
        assertEquals(false, tickets.contains(ticket1));

        consumer.reserveTicket(ticket1);

        assertEquals(true, tickets.contains(ticket1));


        assertEquals(true, consumer.cancelTicket(ticket1));
        assertEquals(false, consumer.cancelTicket(ticket1));


        assertEquals(false, consumer.cancelTicket(ticket));

        consumer.purchaseTicket(ticket);

        assertEquals(true, consumer.cancelTicket(ticket));



    }
    @Test
    public void equalsTest(){
        assertEquals(true,consumer.equals(consumer));
    }
    @Test
    public void getFirst_nameTest(){
        assertEquals("marios",consumer.getFirst_name());
    }
    @Test
    public void setFirst_nameTest(){
        consumer.setFirst_name("Marios");
        assertEquals("Marios",consumer.getFirst_name());
    }
    @Test
    public void getLast_nameTest(){
        assertEquals("raftopoulos",consumer.getLast_name());
    }
    @Test
    public void setLast_nameTest(){
        consumer.setLast_name("Raftopoulos");
        assertEquals("Raftopoulos",consumer.getLast_name());
    }
    @Test
    public void getEmail(){
        assertEquals("raf@gmail.com",consumer.getEmail());
    }
    @Test
    public void setEmail(){
        consumer.setEmail("Raftopoulos@gmail.com");
        assertEquals("Raftopoulos@gmail.com",consumer.getEmail());
    }
}