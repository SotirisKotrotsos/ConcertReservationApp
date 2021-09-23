package com.example.concertreservationapplication.ui.Concert.addNewPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.concertreservationapplication.R;
import java.util.Calendar;
import com.example.concertreservationapplication.daomemory.ConcertDAOMemory;
import com.example.concertreservationapplication.ui.Concert.concertPage.concertPageModel;

/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class addNewConcertModel extends AppCompatActivity implements addNewConcertView{

    private Button buttonAddNewConcert;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_concert);

        addNewConcertPresenter presenter = new addNewConcertPresenter(this, new ConcertDAOMemory());

        buttonAddNewConcert = (Button)findViewById(R.id.buttonConcertAddNewConcert);
        buttonAddNewConcert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onAddConcert();
            }
        });



    }

    /**
     * get concert title from previous activity
     * @return
     */
    @Override
    public String getConcertTitle() {
        return ((EditText)findViewById(R.id.txtConcertTitle)).getText().toString().trim();
    }

    /**
     * get concert date from EditText
     * @return
     */
    @Override
    public Calendar getConcertDate() {
        EditText dateField = findViewById(R.id.concertDate);
        Calendar cl = Calendar.getInstance();
        String editTextVarDate = dateField.getText().toString();
        String[] dateStr = editTextVarDate.split("/");
        int yyyy = Integer.parseInt(dateStr[0]), MM =Integer.parseInt(dateStr[1]), dd = Integer.parseInt(dateStr[2]);
        cl.set(yyyy, MM, dd);
        return cl;
    }

    /**
     * get concert location from EditText
     * @return
     */
    @Override
    public String getLocation() {
        return ((EditText)findViewById(R.id.txtLocationConcert)).getText().toString().trim();
    }

    /**
     * get concert phone number from EditText
     * @return
     */
    @Override
    public String getPhoneNumber() {
        return ((EditText)findViewById(R.id.phoneConcertForContact)).getText().toString().trim();
    }

    /**
     * get concert email address from EditText
     * @return
     */
    @Override
    public String getEmailAddress() {
        return ((EditText)findViewById(R.id.firstName)).getText().toString().trim();
    }

    /**
     * get concert number of arena tickets from EditText
     * @return
     */
    @Override
    public int getNumberOfArenaTickets() {
        return Integer.parseInt(((EditText)findViewById(R.id.numberConcertArenaTickets)).getText().toString().trim());
    }

    /**
     * get concert number of grandstand tickets from EditText
     * @return
     */
    @Override
    public int getNumberOfGrandStandTickets() {
        int i = Integer.parseInt(((EditText)findViewById(R.id.numberConcertGrandstandTickets)).getText().toString().trim());
        System.out.println(i);
        return i;
    }

    /**
     * get concert price of tickets from EditText
     * @return
     */
    @Override
    public float getPriceOfGrandstand() {
        return Float.parseFloat(((EditText)findViewById(R.id.numberConcertPriceOfGrandstandTicket)).getText().toString().trim());
    }

    /**
     * get concert description from EditText
     * @return
     */
    @Override
    public String getDescription() {
        return ((EditText)findViewById(R.id.multilineTextConcertForDescription)).getText().toString().trim();
    }

    /**
     * return on concertPage
     */
    @Override
    public void startPage() {
        Intent intent = new Intent(addNewConcertModel.this, concertPageModel.class);
        startActivity(intent);
    }

}
