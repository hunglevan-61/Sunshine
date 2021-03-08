package hunglevan.ad.sunshine;

import android.graphics.drawable.Drawable;

public class CalendarModel {
    private String day;
    private String dateTime;
    private int maxTemp;
    private int minTemp;
    private int imageWeather;
    private String location;
    private String weather;

    public CalendarModel(String day, String dateTime, int maxTemp, int minTemp, int imageWeather, String location, String weather) {
        this.day = day;
        this.dateTime = dateTime;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.imageWeather = imageWeather;
        this.location = location;
        this.weather = weather;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getImageWeather() {
        return imageWeather;
    }

    public void setImageWeather(int imageWeather) {
        this.imageWeather = imageWeather;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "CalendarModel{" +
                "day='" + day + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", maxTemp=" + maxTemp +
                ", minTemp=" + minTemp +
                ", imageWeather=" + imageWeather +
                ", location='" + location + '\'' +
                ", weather='" + weather + '\'' +
                '}';
    }
}


