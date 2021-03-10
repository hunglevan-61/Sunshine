package hunglevan.ad.sunshine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    private ArrayList<CalendarModel> calendarModelArrayList = new ArrayList<>();
    private CalendarAdapter calendarAdapter;
    int selectIndex = -1;
    public static final int REQUEST_CODE = 100;

    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        generateData();
        setupView(view);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null){
            CalendarModel item = (CalendarModel) data.getSerializableExtra(DetailActivity.CALENDAR_ITEM);
            calendarModelArrayList.set(selectIndex, item);
            calendarAdapter.updateData(calendarModelArrayList);
        }
    }

    private void generateData(){

        CalendarModel day1 = new CalendarModel(
                WeatherType.CLEAR,
                "Today",
                "March 10",
                32,
                23,
                "Ha Noi, Viet Nam",
                24,
                1012,
                3);

        CalendarModel day2 = new CalendarModel(
                WeatherType.CLEAR,
                "Tomorrow",
                "March 11",
                32,
                26,
                "Ha Noi, Viet Nam",
                23,
                1010,
                4);

        CalendarModel day3 = new CalendarModel(
                WeatherType.CLEAR,
                "Friday",
                "March 12",
                31,
                24,
                "Ha Noi, Viet Nam",
                25,
                1010,
                4);

        CalendarModel day4 = new CalendarModel(
                WeatherType.CLEAR,
                "Saturday",
                "March 13",
                35,
                26,
                "Ha Noi, Viet Nam",
                20,
                1013,
                8);

        CalendarModel day5 = new CalendarModel(
                WeatherType.CLEAR,
                "Sunday",
                "March 14",
                28,
                23,
                "Ha Noi, Viet Nam",
                48,
                1013,
                8);

        CalendarModel day6 = new CalendarModel(
                WeatherType.CLEAR,
                "Monday",
                "March 15",
                26,
                22,
                "Ha Noi, Viet Nam",
                63,
                1014,
                5);

        CalendarModel day7 = new CalendarModel(
                WeatherType.CLEAR,
                "Tuesday",
                "March 16",
                28,
                22,
                "Ha Noi, Viet Nam",
                51,
                1013,
                4);

        calendarModelArrayList.add(day1);
        calendarModelArrayList.add(day2);
        calendarModelArrayList.add(day3);
        calendarModelArrayList.add(day4);
        calendarModelArrayList.add(day5);
        calendarModelArrayList.add(day6);
        calendarModelArrayList.add(day7);

    }

    private void setupView(View view){
        RecyclerView recyclerView = view.findViewById(R.id.recycleView);
        calendarAdapter = new CalendarAdapter(calendarModelArrayList, new Callback() {
            @Override
            public void onItemClick(int position, CalendarModel item) {
                openDetailActivity(position, item);
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(calendarAdapter);
    }

    private void openDetailActivity(int position, CalendarModel item){
        selectIndex = position;
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("weather item",item);
        intent.putExtras(bundle);
        startActivityForResult(intent, REQUEST_CODE);
    }

}
