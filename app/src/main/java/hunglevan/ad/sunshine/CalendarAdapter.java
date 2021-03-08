package hunglevan.ad.sunshine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

import javax.security.auth.callback.Callback;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {

    ArrayList<CalendarModel> calendarModelArrayList;

    private static final int VIEW_TYPE_TODAY = 1;
    private static final int VIEW_TYPE_OTHERDAY = 2;
//    Callback callback;


    public CalendarAdapter(ArrayList<CalendarModel> calendarModelArrayList) {
        this.calendarModelArrayList = calendarModelArrayList;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return VIEW_TYPE_TODAY;
        return VIEW_TYPE_OTHERDAY;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        int layout = (viewType == VIEW_TYPE_TODAY) ? R.layout.item_today : R.layout.item_otherday;
        View view = layoutInflater.inflate(layout, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CalendarModel item = calendarModelArrayList.get(position);
        setDataToView(item, holder, position);
    }

    @Override
    public int getItemCount() {
        return calendarModelArrayList.size();
    }

    private void setDataToView(final CalendarModel item, final ViewHolder viewHolder, final int position) {
        View view = viewHolder.getView();

        switch (view.getId()) {
            case R.id.today:
                TextView txtTime = view.findViewById(R.id.txtTime);
                txtTime.setText(item.getDay() + ", " + item.getDateTime());

                TextView txtTodayMaxTemp = view.findViewById(R.id.txtTodayMaxTemp);
                txtTodayMaxTemp.setText(item.getMaxTemp() + "\u00B0");

                TextView txtTodayMinTemp = view.findViewById(R.id.txtTodayMinTemp);
                txtTodayMinTemp.setText(item.getMinTemp() + "\u00B0");

                TextView txtLocation = view.findViewById(R.id.txtLocation);
                txtLocation.setText(item.getLocation());

                ImageView imgTodayWeather = view.findViewById(R.id.imgTodayWeather);
                imgTodayWeather.setImageResource(item.getImageWeather());

                TextView txtTodayWeather = view.findViewById(R.id.txtTodayWeather);
                txtTodayWeather.setText(item.getWeather());

                break;

            case R.id.otherDay:
                ImageView imgWeather = view.findViewById(R.id.imgWeather);
                imgWeather.setImageResource(item.getImageWeather());

                TextView txtDay = view.findViewById(R.id.txtDay);
                txtDay.setText(item.getDay());

                TextView txtWeather = view.findViewById(R.id.txtWeather);
                txtWeather.setText(item.getWeather());

                TextView txtMaxTemp = view.findViewById(R.id.txtMaxTemp);
                txtMaxTemp.setText(item.getMaxTemp() + "\u00B0");

                TextView txtMinTemp = view.findViewById(R.id.txtMinTemp);
                txtMinTemp.setText(item.getMinTemp() + "\u00B0");
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

        View getView() {
            return view;
        }
    }
}
