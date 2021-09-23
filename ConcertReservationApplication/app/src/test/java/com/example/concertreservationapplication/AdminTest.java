package com.example.concertreservationapplication;

import com.example.concertreservationapplication.domain.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.Assert.*;

public class AdminTest {

    private Concert concert ;
    private Concert concert1;
    private Concert concert2;
    private Concert concert3;
    Calendar cl = Calendar.getInstance();
    Calendar cl1 = Calendar.getInstance();
    Calendar cl2 = Calendar.getInstance();
    Calendar cl3 = Calendar.getInstance();
    private Consumer consumer;
    private Admin admin, emptyAdmin;
    private ArrayList<Concert> concerts = new ArrayList<Concert>();

    @Before
    public void setUp() throws Exception {
        consumer = new Consumer("sotiris", "kotrotsos", new Contact("695555555", "sot@gmail.com"));
        cl.set(2021, 6, 1);
        concert = new Concert("Mazw oso zw",cl,"katrakion","Sunaulia gia ton mazw",new Contact("692222222","osozw@mazw.gr"),1,1,10);
        cl1.set(2021, 10, 1);
        concert1 = new Concert("Nikos vertis",cl1,"lykavitos","thelw na me noiwseis",new Contact("691111111","nikos@vertis.gr"),1,1,20);

        cl2.set(2021, 7, 1);
        concert2 = new Concert("Mazw dsdoso zw",cl2,"katrakion","Sunaulia gia ton mazw",new Contact("692222222","osozw@mazw.gr"),1,1,30);
        cl3.set(2021, 3, 1);
        concert3 = new Concert("Nikos vawaertis",cl3,"lykavitos","thelw na me noiwseis",new Contact("691111111","nikos@vertis.gr"),1,1,40);

        //reserve ticket of concerts
        concert.reservationTicket(consumer, "arena", true);
        concert.reservationTicket(consumer, "grandstand", true);
        concert2.reservationTicket(consumer, "arena", true);
        concert2.reservationTicket(consumer, "grandstand", true);
        concert3.reservationTicket(consumer, "arena", true);
        concert3.reservationTicket(consumer, "grandstand", true);
        concert1.reservationTicket(consumer, "arena", true);
        concert1.reservationTicket(consumer, "grandstand", true);

        concerts.add(concert);
        concerts.add(concert1);
        concerts.add(concert2);
        concerts.add(concert3);

        admin = new Admin(concerts, 2021);
        emptyAdmin = new Admin();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void showConcertsBySoldTickets() {

        ArrayList<Concert> c = admin.showConcertsBySoldTickets();
        for (int i = 0; i<c.size(); i++){
            System.out.println(c.get(i).getTitle());
        }
        assertEquals(concert.getTitle(), c.get(0).getTitle());

    }

    @Test
    public void showMonthOfMaxRevenueOfConcerts() {
/*//        System.out.println(concert.getCalendar());
//        System.out.println(concert1.getCalendar());
//        System.out.println("Year: " + concert.getCalendar().get(Calendar.YEAR));
        System.out.println("Month: " + (concert.getCalendar().get(Calendar.MONTH) ));
//        System.out.println("Day: " + concert.getCalendar().get(Calendar.DAY_OF_MONTH));
//        System.out.println("Year: " + concert1.getCalendar().get(Calendar.YEAR));
        System.out.println("Month: " + (concert1.getCalendar().get(Calendar.MONTH) ));
        System.out.println("Month: " + (concert2.getCalendar().get(Calendar.MONTH) ));
        System.out.println("Month: " + (concert3.getCalendar().get(Calendar.MONTH) ));
//        System.out.println("Day: " + concert1.getCalendar().get(Calendar.DAY_OF_MONTH));


        System.out.println(concert.totalRevenue());
        System.out.println(concert1.totalRevenue());

        System.out.println(concert2.totalRevenue());
        System.out.println(concert3.totalRevenue());
        System.out.println("===============");*/
        Object[] obj = admin.showMonthOfMaxRevenueOfConcerts();
//        for( float i: (float[]) obj[1]) System.out.println(i);
        assertEquals(3, obj[1]);
        assertEquals(120, (float) obj[0], 0.0002);

    }
    @Test
    public void equalsTest(){
        Admin admin1 = new Admin(concerts, 2022);
        assertEquals(false,admin.equals(admin1));
    }
    @Test
    public void testGetSet(){

        emptyAdmin.setConcerts(concerts);
        emptyAdmin.setYear(2021);
    }
}