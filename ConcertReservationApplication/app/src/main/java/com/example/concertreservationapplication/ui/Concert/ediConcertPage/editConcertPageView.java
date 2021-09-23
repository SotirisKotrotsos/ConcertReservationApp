package com.example.concertreservationapplication.ui.Concert.ediConcertPage;

import java.util.Calendar;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public interface editConcertPageView {

    /**
     * get from EditText the title
     * @return
     */
    String getConcertTitle();

    /**
     * get from EditText the date
     * @return
     */
    Calendar getConcertDate();

    /**
     * get from EditText the location
     * @return
     */
    String getLocation();

    /**
     * get from EditText the phone number
     * @return
     */
    String getPhoneNumber();

    /**
     * get from EditText the email address
     * @return
     */
    String getEmailAddress();

    /**
     * get from EditText the number of arena tickets
     * @return
     */
    int getNumberOfArenaTickets();

    /**
     * get from EditText the number of grandstand tickets
     * @return
     */
    int getNumberOfGrandStandTickets();

    /**
     * get from EditText the price of grandstand
     * @return
     */
    float getPriceOfGrandstand();

    /**
     * get from EditText the description
     * @return
     */
    String getDescription();

    /**
     * set on EditText the title
     * @param title
     */
    void setConcertTitle(String title);

    /**
     * set on EditText the date
     * @param date
     */
    void setConcertDate(Calendar date);

    /**
     * set on EditText the location
     * @param location
     */
    void setLocation(String location);

    /**
     * set on EditText the phone number
     * @param phoneNumber
     */
    void setPhoneNumber(String phoneNumber);

    /**
     * set on EditText the email address
     * @param emailAddress
     */
    void setEmailAddress(String emailAddress);

    /**
     * set on EditText the number of arena tickets
     * @param numberOfArenaTickets
     */
    void setNumberOfArenaTickets(int numberOfArenaTickets);

    /**
     * set on EditText the number of grandstand tickets
     * @param grandStandTickets
     */
    void setNumberOfGrandStandTickets(int grandStandTickets);

    /**
     * set on EditText the price of grandstand
     * @param priceOfGrandstand
     */
    void setPriceOfGrandstand(float priceOfGrandstand);

    /**
     * set on EditText the description
     * @param description
     */
    void setDescription(String description);

    /**
     * get concert title from previous activity
     * @return
     */
    String getSelecterdConcertTitle();

    /**
     * return on concert page
     */
    void toReturnPage();
}
