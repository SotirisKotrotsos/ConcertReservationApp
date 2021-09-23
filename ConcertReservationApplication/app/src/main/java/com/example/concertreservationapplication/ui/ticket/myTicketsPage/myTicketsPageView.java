package com.example.concertreservationapplication.ui.ticket.myTicketsPage;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public interface myTicketsPageView {
    /**
     * go to activity with selected ticket
     * @param concertTitle
     * @param getphone
     */
    void selectedTicketPage(String concertTitle, String getphone);

    /**
     * get the phone number from previous activity
     * @return
     */
    String getphone();

    /**
     * return on user page activity
     */
    void toStartPage();
}
