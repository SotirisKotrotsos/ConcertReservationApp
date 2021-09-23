package com.example.concertreservationapplication.ui.admin.adminPage;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class adminPagePresenter {

    private adminPageView view;

    /**
     * construtor for presenter
     * @param view
     */
    public adminPagePresenter(adminPageView view) {
        this.view = view;
    }

    /**
     * method to call largest profit month activity
     */
    public void statsForLargestProfitMonth(){view.largest_profit_month();}

    /**
     * method to call most popular concerts
     */
    public void statsForMostPopularConcerts(){view.most_popular_concerts();}

}
