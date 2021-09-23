package com.example.concertreservationapplication.ui.admin.statsForConcerts;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.concertreservationapplication.R;
import com.example.concertreservationapplication.daomemory.ConcertDAOMemory;

public class statsForConcertsModel extends AppCompatActivity implements statsForConcertsView {


    ListView listView;


    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_for_concerts);

        listView = (ListView) findViewById(R.id.list_for_concerts_and_tickets);

        statsForConcertsPresenter presenter = new statsForConcertsPresenter(this, new ConcertDAOMemory());

       /* String yearSelectedForStats = ((EditText) findViewById(R.id.input_year)).getText().toString();
        int year = Integer.parseInt(String.valueOf(yearSelectedForStats));*/
        //int year = getYear();

        String [] concertTicketList = presenter.getConcertAndTicketList();


        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, concertTicketList);

        listView.setAdapter(adapter);
    }

    /**
     * get the year from previous activity
     * @return
     */
    @Override
    public String getYear() {
        return this.getIntent().getExtras().getString("year").trim();
    }
}
