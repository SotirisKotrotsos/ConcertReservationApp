package com.example.concertreservationapplication.ui.ticket.selectedConcertPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.concertreservationapplication.R;
import com.example.concertreservationapplication.daomemory.ConcertDAOMemory;
import com.example.concertreservationapplication.ui.ticket.reserveTicket.reserveConcertPageModel;

/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class selectedConcertPageModel extends AppCompatActivity implements selectedConcertPageView {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_concert_page);

        final selectedConcertPagePresenter presenter = new selectedConcertPagePresenter(this,new ConcertDAOMemory());


        findViewById(R.id.reserveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = getTitleConcert();
                presenter.onReverseTicketPage(title);
            }
        });
    }

    /**
     * get concert title from previus activity
     * @return
     */
    @Override
    public String getTitleConcert() {
        return this.getIntent().getExtras().getString("Concert title");
    }

    /**
     * set on EditText title
     * @param value
     */
    @Override
    public void setConcertTitle(String value) {
        ((TextView)findViewById(R.id.concertTitle)).setText(value);
    }

    /**
     * set on EditText date
     * @param value
     */
    public void setConcertDate(String value) {
        ((TextView)findViewById(R.id.concertDate)).setText(value);
    }

    /**
     * set on EditText location
     * @param value
     */
    @Override
    public void setConcertLocation(String value) {
        ((TextView)findViewById(R.id.concertLocation)).setText(value);
    }

    /**
     * set on EditText description
     * @param value
     */
    @Override
    public void setConcertDescription(String value) {
        ((TextView)findViewById(R.id.concertDescription)).setText(value);
    }

    /**
     * set on EditText price
     * @param value
     */
    public void setConcertPrice(String value) {
        ((TextView)findViewById(R.id.concertPrice)).setText(value);
    }

    /**
     * move to reserve concert page
     * @param title
     */
    @Override
    public void reservePage(String title) {
        Intent intent = new Intent(selectedConcertPageModel.this, reserveConcertPageModel.class);
        intent.putExtra("Concert title",title);
        startActivity(intent);
    }
}
