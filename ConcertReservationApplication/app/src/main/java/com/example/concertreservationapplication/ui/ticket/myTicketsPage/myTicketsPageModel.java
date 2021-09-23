package com.example.concertreservationapplication.ui.ticket.myTicketsPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.concertreservationapplication.R;
import com.example.concertreservationapplication.daomemory.ConsumerDAOMemory;
import com.example.concertreservationapplication.ui.ticket.selectedTicketPage.selectedTicketPageModel;
import com.example.concertreservationapplication.ui.ticket.userPage.userPageModel;

/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class myTicketsPageModel extends AppCompatActivity implements myTicketsPageView {
    ListView listView;
    private AdapterView.OnItemClickListener listClick;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_tickets_page);

        listView = (ListView) findViewById(R.id.listWithTickets);

        myTicketsPagePresenter presenter = new myTicketsPagePresenter(this, new ConsumerDAOMemory());
        try {
            String[] ticketList = presenter.getTicketList();
            ArrayAdapter<String> adapter = new ArrayAdapter(this,
                    android.R.layout.simple_list_item_1,
                    ticketList);


            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                    presenter.onSelectedTicket(ticketList[position], getphone());
                }
            });
        }catch (Exception e){
            toStartPage();
        }
    }

    /**
     * go to activity with selected ticket
     * @param concertTitle
     * @param getphone
     */
    @Override
    public void selectedTicketPage(String concertTitle, String getphone) {
        Intent intent = new Intent(myTicketsPageModel.this, selectedTicketPageModel.class);
        intent.putExtra("Concert title",concertTitle);
        intent.putExtra("phone",getphone);
        startActivity(intent);
    }

    /**
     * get the phone number from previous activity
     * @return
     */
    @Override
    public String getphone() {
        return this.getIntent().getExtras().getString("phone").trim();
    }

    /**
     * return on user page activity
     */
    @Override
    public void toStartPage() {
        Intent intent = new Intent(myTicketsPageModel.this, userPageModel.class);
        Toast toast = Toast.makeText(this,"Not available tickets for customer",Toast.LENGTH_LONG);
        startActivity(intent);
    }


}
