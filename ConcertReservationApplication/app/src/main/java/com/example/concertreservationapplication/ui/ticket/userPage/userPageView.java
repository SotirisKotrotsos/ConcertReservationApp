package com.example.concertreservationapplication.ui.ticket.userPage;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public interface userPageView {

    /**
     * move to my ticket page activity
     */
    void userPageMyTickets();

    /**
     * get phone number from EditText
     * @return
     */
    String getphoneNumber();

    /**
     * move to view converts page activity
     */
    void userPageViewConcerts();
}
