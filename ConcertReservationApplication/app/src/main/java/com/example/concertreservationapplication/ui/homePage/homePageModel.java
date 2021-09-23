package com.example.concertreservationapplication.ui.homePage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.concertreservationapplication.R;
import com.example.concertreservationapplication.daomemory.MemoryInitializer;
import com.example.concertreservationapplication.ui.ticket.userPage.userPageModel;
import com.example.concertreservationapplication.ui.Concert.concertPage.concertPageModel;
import com.example.concertreservationapplication.ui.admin.adminPage.adminPageModel;

/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class homePageModel extends AppCompatActivity implements homePageView {


    private static boolean initialized = false;
    Button buttonLogInAsEmployee;
    Button buttonLogInAsAdmin;
    Button buttonLogInAsUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final homePagePresenter presenter = new homePagePresenter(this);

        buttonLogInAsEmployee = (Button) findViewById(R.id.homePageLogInAsEmployee);
        buttonLogInAsEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onEmployeeInterface();
            }
        });

        buttonLogInAsAdmin = (Button) findViewById(R.id.homePageLogInAsAdmin);
        buttonLogInAsAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onAdminInterface();
            }
        });

        buttonLogInAsUser = (Button) findViewById(R.id.homePageButtonLogInAsUser);
        buttonLogInAsUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onUserInterface();
            }
        });

        if(!initialized)
        {
            new MemoryInitializer().prepareData();
            initialized = true;
        }
    }


    /**
     * log in as admin
     */
    @Override
    public void homePageLogInAsAdmin() {
        Intent intent = new Intent(this, adminPageModel.class);
        startActivity(intent);
    }

    /**
     * log in as user
     */
    @Override
    public void homePageButtonLogInAsUser() {
        Intent intent = new Intent(this, userPageModel.class);
        startActivity(intent);
    }

    /**
     * log in as employee
     */
    public void homePageLogInAsEmployee() {
        Intent intent = new Intent(this, concertPageModel.class);
        startActivity(intent);
    }
}
