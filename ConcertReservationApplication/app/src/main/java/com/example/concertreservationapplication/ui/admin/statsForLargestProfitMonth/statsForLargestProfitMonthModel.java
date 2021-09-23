package com.example.concertreservationapplication.ui.admin.statsForLargestProfitMonth;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.concertreservationapplication.R;
import com.example.concertreservationapplication.daomemory.ConcertDAOMemory;

public class statsForLargestProfitMonthModel extends AppCompatActivity implements statsForLargestProfitMonthView {


    TextView month, maxRevenue;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_for_largest_profit_month);

        statsForLargestProfitMonthPresenter presenter = new statsForLargestProfitMonthPresenter(this, new ConcertDAOMemory());

        Object[] monthRevenueList = presenter.getMonthAndRevenueList();
        month = (TextView) findViewById(R.id.textViewAdminShowMonth);
        maxRevenue = (TextView) findViewById(R.id.textViewAdminShowMaxRevenue);
        presenter.onSetText(monthRevenueList);

    }

    /**
     * get the year from previous activity
     * @return
     */
    @Override
    public String getYear() {
        return this.getIntent().getExtras().getString("year").trim();
    }

    /**
     * setting text with month and max revenue in textView
     * @param obj
     */
    @Override
    public void setText(Object[] obj){
        month.setText("Month: " + String.valueOf((Integer) obj[1]));
        maxRevenue.setText("MaxRevenue: "+String.valueOf((float)obj[0]));
    }
}
