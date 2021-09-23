package com.example.concertreservationapplication.ui.ticket.userPage;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class userPagePresenter {

    private userPageView view;

    /**
     * move to my ticket page activity
     */
    public userPagePresenter(userPageView view){this.view = view;}

    /**
     * get phone number from EditText
     * @return
     */
    public void onMyTicketsInterface(){view.userPageMyTickets();}

    /**
     * move to view converts page activity
     */
    public void onViewConcertsInterface(){view.userPageViewConcerts();}
}
