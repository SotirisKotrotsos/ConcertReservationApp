package com.example.concertreservationapplication.ui.ticket.selectedTicketPage;

public interface selectedTicketPageView {

    /**
     * get the concert title from previous activity
     * @return
     */
    String getTitleConcert();

    /**
     * set on TextView the first name
     * @param value
     */
    void setFirstName(String value);

    /**
     * set on TextView the last name
     * @param value
     */
    void setLastName(String value);

    /**
     * set on TextView the title
     * @param value
     */
    void setConcertTitle(String value);

    /**
     * set on TextView the location
     * @param value
     */
    void setConcertLocation(String value);

    /**
     * set on TextView the ticket category
     * @param value
     */
    void setTicketCategory(String value);

    /**
     * get the phone number from previous activity
     * @return
     */
    String getphone();

    /**
     * return on user page activity
     */
    void tostartPage();
}
