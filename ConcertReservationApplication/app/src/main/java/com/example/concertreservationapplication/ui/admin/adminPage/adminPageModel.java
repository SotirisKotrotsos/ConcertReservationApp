package com.example.concertreservationapplication.ui.admin.adminPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.concertreservationapplication.R;
import com.example.concertreservationapplication.ui.admin.statsForConcerts.statsForConcertsModel;
import com.example.concertreservationapplication.ui.admin.statsForLargestProfitMonth.statsForLargestProfitMonthModel;
/**
 * @author George Karampelas
 * @author Sotiris Kotrotsos
 * @author Marios Raftopoulos
 */
public class adminPageModel extends AppCompatActivity implements adminPageView {

        TextView vs;
        Button lpm;
        Button mpc;
        int inputYear;
        EditText editText;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        adminPagePresenter presenter = new adminPagePresenter(this);
        vs = findViewById(R.id.view_stats_for);
        lpm = findViewById(R.id.largest_profit_month);
        mpc = findViewById(R.id.most_popular_concerts);

        lpm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.statsForLargestProfitMonth();

            }
        });

        mpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.statsForMostPopularConcerts();
            }
        });

    }

    /**
     * action for button that will call statsForLargestProfitMonth activity
     */
    @Override
    public void largest_profit_month() {
        String inputYear1 = getYearFromEditText();
        System.out.println("kkkkkk --> "+inputYear1);
        Intent intent = new Intent(this ,  statsForLargestProfitMonthModel.class);
        intent.putExtra("year",inputYear1);
        startActivity(intent);

    }

    /**
     * action for button that will call statsForConcerts activity
     */
    @Override
    public void most_popular_concerts() {
        String inputYear1 = getYearFromEditText();
        System.out.println("kkkkkk --> "+inputYear1);
        Intent intent = new Intent(this ,  statsForConcertsModel.class);
        intent.putExtra("year",inputYear1);
        startActivity(intent);

    }

    /**
     * get the value of edit text, it takes the year that admin chose
     * @return
     */
    private String getYearFromEditText(){
        return ((EditText) findViewById(R.id.inputYear)).getText().toString().trim();
    }
}
