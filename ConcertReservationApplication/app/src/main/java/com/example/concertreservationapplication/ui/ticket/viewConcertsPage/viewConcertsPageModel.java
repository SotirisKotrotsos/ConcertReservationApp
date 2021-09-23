package com.example.concertreservationapplication.ui.ticket.viewConcertsPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.concertreservationapplication.R;
import com.example.concertreservationapplication.daomemory.ConcertDAOMemory;
import com.example.concertreservationapplication.ui.ticket.selectedConcertPage.selectedConcertPageModel;

/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class viewConcertsPageModel extends AppCompatActivity implements viewConcertsPageView {

    ListView listView;
    private AdapterView.OnItemClickListener listClick;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_concerts_page);

        listView = (ListView) findViewById(R.id.listWithCocnerts);

        viewConcertsPagePresenter presenter = new viewConcertsPagePresenter(this, new ConcertDAOMemory());
        String[] concertsList = presenter.getConcertsList();
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                concertsList);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                presenter.onSelectedConcert(concertsList[position]);
            }
        });
    }


    /**
     * move to selected concert page
     * @param concertTitle
     */
    @Override
    public void selectedConcertPage(String concertTitle) {

        Intent intent = new Intent(viewConcertsPageModel.this, selectedConcertPageModel.class);
        intent.putExtra("Concert title",concertTitle);
        startActivity(intent);
    }



}
