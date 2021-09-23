package com.example.concertreservationapplication.ui.ticket.reserveTicket;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public interface reserveConcertPageView {

    /**
     * get from EditText the first name
     * @return
     */
    String getFirstName();

    /**
     * get from EditText the last name
     * @return
     */
    String getLastName();

    /**
     * get from EditText the phone number
     * @return
     */
    String getPhoneNumber();

    /**
     * get from EditText the email address
     * @return
     */
    String getEmail();

    /**
     * get from EditText the category
     * @return
     */
    String getCategory();

    /**
     * reserve ticket
     */
    void resrveTicket();

    /**
     * buy ticket
     */
    void buyTicket();

    /**
     * get the concert title of previous activity
     * @return
     */
    String getTitleConcert();

    /**
     * go back on user page
     */
    void onstartPage();
}
