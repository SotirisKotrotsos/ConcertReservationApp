package com.example.concertreservationapplication.ui.ticket.userPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.concertreservationapplication.R;
import com.example.concertreservationapplication.ui.ticket.myTicketsPage.myTicketsPageModel;
import com.example.concertreservationapplication.ui.ticket.viewConcertsPage.viewConcertsPageModel;

/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class userPageModel extends AppCompatActivity implements userPageView {

    private static boolean initialized = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_page);

        final userPagePresenter presenter = new userPagePresenter(this);

        findViewById(R.id.employeePageMyTicketButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onMyTicketsInterface();
            }
        });
        findViewById(R.id.employeePageViewConcertsButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onViewConcertsInterface();
            }
        });
    }

    /**
     * move to my ticket page activity
     */
    @Override
    public void userPageMyTickets() {
        String phone_number = getphoneNumber();
        Intent intent = new Intent(userPageModel.this, myTicketsPageModel.class);
        intent.putExtra("phone",phone_number);
        startActivity(intent);
    }

    /**
     * get phone number from EditText
     * @return
     */
    @Override
    public String getphoneNumber() {
        return ((EditText)findViewById(R.id.phoneNumberUserPage)).getText().toString().trim();
    }

    /**
     * move to view converts page activity
     */
    @Override
    public void userPageViewConcerts() {
        Intent intent = new Intent(userPageModel.this, viewConcertsPageModel.class);
        startActivity(intent);
    }
}
