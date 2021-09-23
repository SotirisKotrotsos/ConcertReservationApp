package com.example.concertreservationapplication.ui.homePage;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class homePagePresenter {

    private homePageView view;

    /**
     * presenter's constructor
     * @param view
     */
    public homePagePresenter(homePageView view)
    {
        this.view = view;
    }

    /**
     * log in as admin
     */
    public void onAdminInterface(){view.homePageLogInAsAdmin();}

    /**
     * log in as user
     */
    public void onUserInterface(){view.homePageButtonLogInAsUser();}

    /**
     * log in as employee
     */
    public void onEmployeeInterface(){view.homePageLogInAsEmployee();}


}
