package com.example.concertreservationapplication.ui.Concert.concertPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.concertreservationapplication.R;
import com.example.concertreservationapplication.ui.Concert.addNewPage.addNewConcertModel;
import com.example.concertreservationapplication.ui.Concert.editPage.editPageModel;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class concertPageModel extends AppCompatActivity implements concertPageView {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concert_page);

        final concertPagePresenter presenter = new concertPagePresenter(this);

        findViewById(R.id.bt_concert_page_add_new_concert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onAddNewConcert();
            }
        });

        findViewById(R.id.bt_concert_edit_current_concert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onEditCurrentConcert();
            }
        });
    }

    /**
     *  go to add new concert activity
     */
    @Override
    public void addNewConcert() {
        Intent intent = new Intent(concertPageModel.this, addNewConcertModel.class);
        startActivity(intent);
    }

    /**
     * go to edit current concert activity
     */
    @Override
    public void editCurrentConcert() {
        Intent intent = new Intent(concertPageModel.this, editPageModel.class);
        startActivity(intent);
    }
}
