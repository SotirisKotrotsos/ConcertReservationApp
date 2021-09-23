package com.example.concertreservationapplication.ui.ticket.selectedConcertPage;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public interface selectedConcertPageView {

    /**
     * get concert title from previus activity
     * @return
     */
    String getTitleConcert();

    /**
     * set on EditText title
     * @param value
     */
    void setConcertTitle(String value);

    /**
     * set on EditText date
     * @param value
     */
    void setConcertDate(String value);

    /**
     * set on EditText location
     * @param value
     */
    void setConcertLocation(String value);

    /**
     * set on EditText description
     * @param value
     */
    void setConcertDescription(String value);

    /**
     * set on EditText price
     * @param value
     */
    void setConcertPrice(String value);

    /**
     * move to reserve concert page
     * @param title
     */
    void reservePage(String title);
}
