package com.example.concertreservationapplication.ui.ticket.reserveTicket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
public class reserveConcertPageModel extends AppCompatActivity implements reserveConcertPageView {

    private Button reserveTicket,buyTicket;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_ticket_page);
        reserveConcertPagePresenter presenter = new reserveConcertPagePresenter(this, new ConcertDAOMemory(),new ConsumerDAOMemory());

        reserveTicket = (Button)findViewById(R.id.reserveButtonInReservePage);
        buyTicket = (Button)findViewById(R.id.buyButton);
        reserveTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onReserveTicket();
            }
        });
        buyTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onBuyTicket();
            }
        });
    }

    /**
     * get the concert title of previous activity
     * @return
     */
    @Override
    public String getTitleConcert() {
        return this.getIntent().getExtras().getString("Concert title");
    }

    /**
     * get from EditText the first name
     * @return
     */
    @Override
    public String getFirstName() {
        return ((EditText)findViewById(R.id.firstName)).getText().toString().trim();
    }

    /**
     * get from EditText the last name
     * @return
     */
    @Override
    public String getLastName() {
        return ((EditText)findViewById(R.id.lastName)).getText().toString().trim();
    }

    /**
     * get from EditText the phone number
     * @return
     */
    @Override
    public String getPhoneNumber() {
        return ((EditText)findViewById(R.id.phoneNumber)).getText().toString().trim();
    }

    /**
     * get from EditText the email address
     * @return
     */
    @Override
    public String getEmail() {
        return ((EditText)findViewById(R.id.email)).getText().toString().trim();
    }

    /**
     * get from EditText the category
     * @return
     */
    @Override
    public String getCategory() {
        return ((EditText)findViewById(R.id.category)).getText().toString().trim();
    }

    /**
     * reserve ticket
     */
    @Override
    public void resrveTicket() {

    }

    /**
     * buy ticket
     */
    @Override
    public void buyTicket() {

    }

    /**
     * go back on user page
     */
    @Override
    public void onstartPage() {
        Intent intent = new Intent(reserveConcertPageModel.this, userPageModel.class);
        startActivity(intent);
    }
}
