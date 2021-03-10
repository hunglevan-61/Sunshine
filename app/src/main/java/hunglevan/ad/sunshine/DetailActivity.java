package hunglevan.ad.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    public static final String CALENDAR_ITEM = "Calendar";
    public static final String WEATHER_DETAIL = "WeartherDetail";
    public static final int RESULT_CHANGE_WEATHER = 10;
    CalendarModel calendarModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        calendarModel = (CalendarModel) intent.getSerializableExtra("weather item");

        TextView txtDay = findViewById(R.id.txtDay);
        txtDay.setText(calendarModel.getDay());

        TextView txtTime = findViewById(R.id.txtTime);
        txtTime.setText(calendarModel.getDate());

        TextView txtMaxTemp = findViewById(R.id.txtMaxTemp);
        txtMaxTemp.setText(calendarModel.getMaxTemp() + "\u00B0");

        TextView txtMinTemp = findViewById(R.id.txtMinTemp);
        txtMinTemp.setText(calendarModel.getMinTemp() + "\u00B0");

        TextView txtHumidity = findViewById(R.id.txtHumindity);
        txtHumidity.setText("Humandity: " + calendarModel.getHumidity() + " %");

        TextView txtPressure = findViewById(R.id.txtPressure);
        txtPressure.setText("Pressure: " + calendarModel.getPressure() + " hPa");

        TextView txtWind = findViewById(R.id.txtWind);
        txtWind.setText("Wind: " + calendarModel.getWind() + " km/h NE");

        TextView txtLocation = findViewById(R.id.txtLocation);
        txtLocation.setText("Location: " + calendarModel.getLocation());

        TextView txtWeather = findViewById(R.id.txtWeather);
        txtWeather.setText(calendarModel.getWeather());

        ImageView imgWeather = findViewById(R.id.imgWeather);
        imgWeather.setImageResource(calendarModel.getBigImageWeather());

    }

    @Override
    public void onBackPressed() {
        calendarModel.setWeatherType(WeatherType.CLOUDS);
        Intent resultInten = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable(CALENDAR_ITEM, calendarModel);
        resultInten.putExtras(bundle);

        setResult(RESULT_CHANGE_WEATHER, resultInten);
        super.onBackPressed();
    }
}
