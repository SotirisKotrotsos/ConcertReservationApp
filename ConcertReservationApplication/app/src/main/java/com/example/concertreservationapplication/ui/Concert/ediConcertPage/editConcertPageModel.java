package com.example.concertreservationapplication.ui.Concert.ediConcertPage;

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
public class editConcertPageModel extends AppCompatActivity implements editConcertPageView {

    Button buttonSaveChanges;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_concert_selected_page);

        editConcertPagePresenter presenter = new editConcertPagePresenter(this, new ConcertDAOMemory());
        presenter.onShowFields();

        buttonSaveChanges = findViewById(R.id.buttonConcertSaveChanges);
        buttonSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onEditFields();
            }
        });
    }

    /**
     * get from EditText the title
     * @return
     */
    @Override
    public String getConcertTitle() {
        return ((EditText)findViewById(R.id.txtConcertTitleEditPage)).getText().toString().trim();
    }

    /**
     * get from EditText the date
     * @return
     */
    @Override
    public Calendar getConcertDate() {
        EditText dateField = findViewById(R.id.concertDateEditPage);
        Calendar cl = Calendar.getInstance();
        String editTextVarDate = dateField.getText().toString();
        String[] dateStr = editTextVarDate.split("/");
        int yyyy = Integer.parseInt(dateStr[0]), MM =Integer.parseInt(dateStr[1]), dd = Integer.parseInt(dateStr[2]);
        cl.set(yyyy, MM, dd);
        return cl;
    }

    /**
     * get from EditText the location
     * @return
     */
    @Override
    public String getLocation() {
        return ((EditText)findViewById(R.id.txtLocationConcertEditPage)).getText().toString().trim();
    }

    /**
     * get from EditText the phone number
     * @return
     */
    @Override
    public String getPhoneNumber() {
        return ((EditText)findViewById(R.id.phoneConcertForContactEditPage)).getText().toString().trim();
    }

    /**
     * get from EditText the email address
     * @return
     */
    @Override
    public String getEmailAddress() {
        return ((EditText)findViewById(R.id.firstNameEditPage)).getText().toString().trim();
    }

    /**
     * get from EditText the number of arena tickets
     * @return
     */
    @Override
    public int getNumberOfArenaTickets() {
        return Integer.parseInt(((EditText)findViewById(R.id.numberConcertArenaTicketsEditPage)).getText().toString().trim());
    }

    /**
     * get from EditText the number of grandstand tickets
     * @return
     */
    @Override
    public int getNumberOfGrandStandTickets() {
        int i = Integer.parseInt(((EditText)findViewById(R.id.numberConcertGrandstandTicketsEditPage)).getText().toString().trim());
        System.out.println(i);
        return i;
    }

    /**
     * get from EditText the price of grandstand
     * @return
     */
    @Override
    public float getPriceOfGrandstand() {
        return Float.parseFloat(((EditText)findViewById(R.id.numberConcertPriceOfGrandstandTicketEditPage)).getText().toString().trim());
    }

    /**
     * get from EditText the description
     * @return
     */
    @Override
    public String getDescription() {
        return ((EditText)findViewById(R.id.multilineTextConcertForDescriptionEditPage)).getText().toString().trim();
    }

    /**
     * set on EditText the title
     * @param title
     */
    @Override
    public void setConcertTitle(String title) {
        ((EditText)findViewById(R.id.txtConcertTitleEditPage)).setText(title);
    }

    /**
     * set on EditText the date
     * @param calendar
     */
    @Override
    public void setConcertDate(Calendar calendar) {
        int yyyy = calendar.get(Calendar.YEAR);
        int MM = calendar.get(Calendar.MONTH);
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        ((EditText) findViewById(R.id.concertDateEditPage)).setText(yyyy+"/"+MM+"/"+dd);
    }

    /**
     * set on EditText the location
     * @param location
     */
    @Override
    public void setLocation(String location) {
        ((EditText)findViewById(R.id.txtLocationConcertEditPage)).setText(location);
    }

    /**
     * set on EditText the phone number
     * @param phoneNumber
     */
    @Override
    public void setPhoneNumber(String phoneNumber) {
        ((EditText)findViewById(R.id.phoneConcertForContactEditPage)).setText(phoneNumber);
    }

    /**
     * set on EditText the email address
     * @param emailAddress
     */
    @Override
    public void setEmailAddress(String emailAddress) {
        ((EditText)findViewById(R.id.firstNameEditPage)).setText(emailAddress);
    }

    /**
     * set on EditText the number of arena tickets
     * @param numberOfArenaTickets
     */
    @Override
    public void setNumberOfArenaTickets(int numberOfArenaTickets) {
        ((EditText)findViewById(R.id.numberConcertArenaTicketsEditPage)).setText(String.valueOf((int) numberOfArenaTickets));
    }

    /**
     * set on EditText the number of grandstand tickets
     * @param numberOfGrandStandTickets
     */
    @Override
    public void setNumberOfGrandStandTickets(int numberOfGrandStandTickets) {
        ((EditText)findViewById(R.id.numberConcertGrandstandTicketsEditPage)).setText(String.valueOf((int)numberOfGrandStandTickets));
    }

    /**
     * set on EditText the price of grandstand
     * @param priceOfGrandstand
     */
    @Override
    public void setPriceOfGrandstand(float priceOfGrandstand) {
        ((EditText)findViewById(R.id.numberConcertPriceOfGrandstandTicketEditPage)).setText(String.valueOf((float)priceOfGrandstand));
    }

    /**
     * set on EditText the description
     * @param description
     */
    @Override
    public void setDescription(String description) {
        ((EditText)findViewById(R.id.multilineTextConcertForDescriptionEditPage)).setText(description);
    }
    /**
     * get concert title from previous activity
     * @return
     */
    @Override
    public String getSelecterdConcertTitle() {
        return this.getIntent().getExtras().getString("title").trim();
    }

    /**
     * return on concert page
     */
    @Override
    public void toReturnPage(){
        Intent intent = new Intent(this, concertPageModel.class);
        startActivity(intent);
    }
}
