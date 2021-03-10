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

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {

    private static final int VIEW_TYPE_TODAY = 1;
    private static final int VIEW_TYPE_OTHERDAY = 2;
    private ArrayList<CalendarModel> calendarModelArrayList;
    Callback callback;

    public CalendarAdapter(ArrayList<CalendarModel> calendarModelArrayList, Callback callback) {
        this.callback = callback;
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
        int layout = (viewType == VIEW_TYPE_TODAY) ? R.layout.item_today : R.layout.item_otherday;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(layout, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setDataToView(holder.getView(), position);
    }

    public void updateData(ArrayList<CalendarModel> calendarModels) {
        this.calendarModelArrayList = calendarModels;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return calendarModelArrayList.size();
    }

    private void setDataToView(View view, final int position) {
        final CalendarModel item = calendarModelArrayList.get(position);
        TextView txtTime = view.findViewById(R.id.txtTime);
        TextView txtLocation = view.findViewById(R.id.txtLocation);
        ImageView imgWeather = view.findViewById(R.id.imgWeather);
        TextView txtDay = view.findViewById(R.id.txtDay);

        if (view.getId() == R.id.today) {
            txtTime.setText(item.getDay() + ", " + item.getDate());
            txtLocation.setText(item.getLocation());
            imgWeather.setImageResource(item.getBigImageWeather());
        }else {
            txtDay.setText(item.getDay());
            imgWeather.setImageResource(item.getSmallImageWeather());
        }

        TextView txtMaxTemp = view.findViewById(R.id.txtMaxTemp);
        txtMaxTemp.setText(item.getMaxTemp() + "\u00B0");

        TextView txtMinTemp = view.findViewById(R.id.txtMinTemp);
        txtMinTemp.setText(item.getMinTemp() + "\u00B0");

        TextView txtWeather = view.findViewById(R.id.txtWeather);
        txtWeather.setText(item.getWeather());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onItemClick(position, item);
            }
        });

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

