package hunglevan.ad.sunshine;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class CalendarModel implements Serializable {
    private WeatherType weatherType;
    private String day;

    public void setWeatherType(WeatherType weatherType) {
        this.weatherType = weatherType;
    }

    private String date;
    int maxTemp;
    int minTemp;
    String location;
    int humidity;
    int pressure;
    int wind;

    public CalendarModel(WeatherType weatherType, String day, String date, int maxTemp, int minTemp, String location, int humidity, int pressure, int wind) {
        this.weatherType = weatherType;
        this.day = day;
        this.date = date;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.location = location;
        this.humidity = humidity;
        this.pressure = pressure;
        this.wind = wind;
    }

    public WeatherType getWeatherType() {
        return weatherType;
    }

    public String getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public String getLocation() {
        return location;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public int getWind() {
        return wind;
    }

    public int getSmallImageWeather(){
        int resId = 0;
        switch (weatherType){
            case CLEAR:
                resId = R.drawable.ic_clear;
                break;
            case CLOUDS:
                resId = R.drawable.ic_cloudy;
                break;
            case FOG:
                resId = R.drawable.ic_fog;
                break;
            case LIGHT_CLOUDS:
                resId = R.drawable.ic_light_clouds;
                break;
            case RAIN:
                resId = R.drawable.ic_rain;
                break;
            case SNOW:
                resId = R.drawable.ic_snow;
                break;
            case STORM:
                resId = R.drawable.ic_storm;
                break;
            case LIGHT_RAIN:
                resId = R.drawable.ic_light_rain;
                break;
        }
        return resId;
    }

    public int getBigImageWeather(){
        int resId = 0;
        switch (weatherType){
            case CLEAR:
                resId = R.drawable.art_clear;
                break;
            case CLOUDS:
                resId = R.drawable.art_clouds;
                break;
            case FOG:
                resId = R.drawable.art_fog;
                break;
            case LIGHT_CLOUDS:
                resId = R.drawable.art_light_clouds;
                break;
            case RAIN:
                resId = R.drawable.art_rain;
                break;
            case SNOW:
                resId = R.drawable.art_snow;
                break;
            case STORM:
                resId = R.drawable.art_storm;
                break;
            case LIGHT_RAIN:
                resId = R.drawable.art_light_rain;
                break;
        }
        return resId;
    }

    public String getWeather(){
        String weather = "";
        switch (weatherType){
            case CLEAR:
                weather = "Clear";
                break;
            case CLOUDS:
                weather = "Clouds";
                break;
            case FOG:
                weather = "Fog";
                break;
            case LIGHT_CLOUDS:
                weather = "Light Clouds";
                break;
            case RAIN:
                weather = "Rain";
                break;
            case SNOW:
                weather = "Snow";
                break;
            case STORM:
                weather = "Storm";
                break;
            case LIGHT_RAIN:
                weather = "Light Rain";
                break;
        }
        return weather;
    }
}


