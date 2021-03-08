package hunglevan.ad.sunshine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    ArrayList<CalendarModel> calendarModelArrayList = new ArrayList<>();
    CalendarAdapter calendarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapIdToView();
        setToolbar();
        generateData();
        setupView();
    }

    private void mapIdToView(){
        toolbar =  findViewById(R.id.toolbar);
    }

    private void setToolbar(){
        setSupportActionBar(toolbar);
        toolbar.setTitleTextAppearance(this, R.style.customToolbar);
    }

    private void generateData(){
        CalendarModel day1 = new CalendarModel("Saturday", "March 6", 20, 9, R.drawable.ic_clear, "Hoai Duc, Ha Noi", "Clear");
        CalendarModel day2 = new CalendarModel("Sunday", "March 7", 18, 10, R.drawable.ic_rain, "Hoai Duc, Ha Noi", "Rain");
        CalendarModel day3 = new CalendarModel("Monday", "March 8", 22, 13, R.drawable.ic_cloudy, "Hoai Duc, Ha Noi", "Cloudy");
        CalendarModel day4 = new CalendarModel("Tuesday", "March 9", 17, 11, R.drawable.ic_storm, "Hoai Duc, Ha Noi", "Storm");
        CalendarModel day5 = new CalendarModel("Wednesday", "March 10", 23, 12, R.drawable.ic_clear, "Hoai Duc, Ha Noi", "Clear");
        CalendarModel day6 = new CalendarModel("Thursday", "March 11", 21, 10, R.drawable.ic_rain, "Hoai Duc, Ha Noi", "Rain");
        CalendarModel day7 = new CalendarModel("Friday", "March 12", 22, 12, R.drawable.ic_rain, "Hoai Duc, Ha Noi", "Rain");

        calendarModelArrayList.add(day1);
        calendarModelArrayList.add(day2);
        calendarModelArrayList.add(day3);
        calendarModelArrayList.add(day4);
        calendarModelArrayList.add(day5);
        calendarModelArrayList.add(day6);
        calendarModelArrayList.add(day7);

        calendarModelArrayList.set(0, new CalendarModel("Today", "March 6", 20, 9, R.drawable.art_clear, "Hoai Duc, Ha Noi", "Clear"));
        calendarModelArrayList.set(1, new CalendarModel("Tomorrow", "March 7", 18, 10, R.drawable.ic_rain, "Hoai Duc, Ha Noi", "Rain"));
    }

    private void setupView(){
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        calendarAdapter = new CalendarAdapter(calendarModelArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(calendarAdapter);
    }
}