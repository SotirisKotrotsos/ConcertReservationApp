package com.example.concertreservationapplication.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Objects;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class Admin {

    private ArrayList<Concert> concerts;
    private int year;
    private Calendar calendar = Calendar.getInstance();
    private float[] months = new float[12]; // 0-Jan 1-Feb ...

    /**
     * constructor of admin
     * @param concerts
     * @param year
     */
    public Admin(ArrayList<Concert> concerts, int year){
        this.concerts = concerts;
        this.year = year;
    };


    /**
     * default constructor
     */
    public Admin(){};

    /**
     * get all concerts
     * @return
     */
    public ArrayList<Concert> getConcerts() {
        return concerts;
    }

    /**
     * set the concerts
     * @param concerts
     */
    public void setConcerts(ArrayList<Concert> concerts) {
        this.concerts = concerts;
    }

    /**
     * get year
     * @return
     */
    public int getYear() {
        return year;
    }

    /**
     * set year
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * check if two instances of admin have same values
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return year == admin.year &&
                Objects.equals(concerts, admin.concerts) &&
                Objects.equals(calendar, admin.calendar) &&
                Arrays.equals(months, admin.months);
    }

    /**
     * return arraylist with all concerts shorted by sold tickets
     * @return
     */
    public ArrayList<Concert> showConcertsBySoldTickets(){

        ArrayList<Concert> concertsPerSoldTickets = new ArrayList<Concert>();

        Collections.sort(concerts, new ConcertTicketsComparator());

        Concert concert;

        for (int counter = 0; counter < concerts.size(); counter++){

            concert = concerts.get(counter);

            if (concert.getCalendar().get(Calendar.YEAR) == this.year){
                concertsPerSoldTickets.add(concert);
            }

        }

        return concertsPerSoldTickets;

    }

    /**
     * return the number of month with max revenues
     * and the float number of revenues
     * @return
     */
    public Object[] showMonthOfMaxRevenueOfConcerts(){

        Concert concert;

        Object[] obj = new Object[2];

        for (int counter = 0; counter < concerts.size(); counter++){

            concert = concerts.get(counter);

            if (concert.getCalendar().get(Calendar.YEAR) == this.year){

                int month = concert.getCalendar().get(Calendar.MONTH);

                if(month == 1) months[0] += concert.totalRevenue();
                if(month == 2)months[1] += concert.totalRevenue();
                if(month == 3)months[2] += concert.totalRevenue();
                if(month == 4)months[3] += concert.totalRevenue();
                if(month == 5)months[4] += concert.totalRevenue();
                if(month == 6)months[5] += concert.totalRevenue();
                if(month == 7)months[6] += concert.totalRevenue();
                if(month == 8)months[7] += concert.totalRevenue();
                if(month == 9)months[8] += concert.totalRevenue();
                if(month == 10)months[9] += concert.totalRevenue();
                if(month == 11)months[10] += concert.totalRevenue();
                if(month == 12)months[11] += concert.totalRevenue();

            }
        }

        float max = 0;
        int monthMax = 0;
        for(int counter = 0; counter < months.length; counter++) {
            if(months[counter] > max) {
                max = months[counter];
                monthMax = counter + 1;
            };

        }
        obj[0] = max;
        obj[1] = monthMax;

        return obj;
    }
}
