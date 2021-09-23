package com.example.concertreservationapplication.ui.Concert.concertPage;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class concertPagePresenter {

    private concertPageView view;

    /**
     * presenter's constructor
     * @param view
     */
    public concertPagePresenter(concertPageView view){this.view = view;}

    /**
     * move to add new concert activity
     */
    public void onAddNewConcert(){view.addNewConcert();}

    /**
     * move to edit current concert activity
     */
    public void onEditCurrentConcert(){view.editCurrentConcert();}
}
