package com.example.concertreservationapplication.ui.Concert.editPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.concertreservationapplication.R;
import com.example.concertreservationapplication.daomemory.ConcertDAOMemory;
import com.example.concertreservationapplication.ui.Concert.ediConcertPage.editConcertPageModel;

/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class editPageModel extends AppCompatActivity implements editPageView {

    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_page);

        listView = (ListView) findViewById(R.id.listViewForEditConcert);

        editPagePresenter presenter = new editPagePresenter(this, new ConcertDAOMemory());

        String[] concertsName = presenter.concertsName();

//        ArrayList<String> concertNamesList = new ArrayList<>(Arrays.asList(concertsName));
//        String[] list= {"sot","kar"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, concertsName);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                presenter.onClickConcert(concertsName[i]);
            }
        });


    }

    /**
     * go to activity and pass the chosen concert
     * @param concert
     */
    @Override
    public void clickConcert(String concert) {
        Intent intent = new Intent(this, editConcertPageModel.class);
        intent.putExtra("title",concert);
        startActivity(intent);
    }


}
