package com.example.concertreservationapplication.ui.ticket.selectedTicketPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.concertreservationapplication.R;
import com.example.concertreservationapplication.daomemory.ConcertDAOMemory;
import com.example.concertreservationapplication.daomemory.ConsumerDAOMemory;
import com.example.concertreservationapplication.ui.ticket.userPage.userPageModel;

/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class selectedTicketPageModel extends AppCompatActivity implements selectedTicketPageView {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_ticket_page);

        final selectedTicketPagePresenter presenter = new selectedTicketPagePresenter(this,new ConsumerDAOMemory(), new ConcertDAOMemory());


        findViewById(R.id.cancelTicketButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = getTitleConcert();
                presenter.cancelTicket(title);
            }
        });
    }

    /**
     * get the concert title from previous activity
     * @return
     */
    @Override
    public String getTitleConcert() {
        return this.getIntent().getExtras().getString("Concert title");
    }

    /**
     * get the phone number from previous activity
     * @return
     */
    public String getphone(){
        return this.getIntent().getExtras().getString("phone");
    }

    /**
     * set on TextView the first name
     * @param value
     */
    @Override
    public void setFirstName(String value) {
        ((TextView)findViewById(R.id.firstName)).setText(value);
    }


    /**
     * set on TextView the last name
     * @param value
     */
    @Override
    public void setLastName(String value) {
        ((TextView)findViewById(R.id.lastName)).setText(value);
    }


    /**
     * set on TextView the title
     * @param value
     */
    @Override
    public void setConcertTitle(String value) {
        ((TextView)findViewById(R.id.concertTitle)).setText(value);
    }

    /**
     * set on TextView the location
     * @param value
     */
    @Override
    public void setConcertLocation(String value) {
        ((TextView)findViewById(R.id.concertLocation)).setText(value);
    }

    /**
     * set on TextView the ticket category
     * @param value
     */
    @Override
    public void setTicketCategory(String value) {
        ((TextView)findViewById(R.id.ticketCategory)).setText(value);
    }

    /**
     * return on user page activity
     */
    @Override
    public void tostartPage() {
        Intent intent = new Intent(selectedTicketPageModel.this, userPageModel.class);
        startActivity(intent);
    }
}
