package com.example.concertreservationapplication.ui.Concert.addNewPage;

import java.util.Calendar;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public interface addNewConcertView {
    /**
     * get concert title from previous activity
     * @return
     */
    String getConcertTitle();
    /**
     * get concert date from EditText
     * @return
     */
    Calendar getConcertDate();
    /**
     * get concert location from EditText
     * @return
     */
    String getLocation();
    /**
     * get concert phone number from EditText
     * @return
     */
    String getPhoneNumber();
    /**
     * get concert email address from EditText
     * @return
     */
    String getEmailAddress();
    /**
     * get concert number of arena tickets from EditText
     * @return
     */
    int getNumberOfArenaTickets();
    /**
     * get concert number of grandstand tickets from EditText
     * @return
     */
    int getNumberOfGrandStandTickets();
    /**
     * get concert price of tickets from EditText
     * @return
     */
    float getPriceOfGrandstand();
    /**
     * get concert description from EditText
     * @return
     */
    String getDescription();
    /**
     * return on concertPage
     */
    void startPage();
}
