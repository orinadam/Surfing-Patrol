package com.example.surfingpatrol;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SpotsListAdapter extends ArrayAdapter<Spot> {
    private Context mContext;
    private List<Spot> spots;
    public SpotsListAdapter(Context context, List<Spot> spots) {
        super(context, R.layout.spot_item_row, spots);
        // TODO Auto-generated constructor stub

        this.mContext=context;
        this.spots = spots;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(mContext);
        View rowView=inflater.inflate(R.layout.spot_item_row, null);
        Spot spot = getItem(position);

        TextView name = (TextView) rowView.findViewById(R.id.spot_name);
        TextView temperature = (TextView) rowView.findViewById(R.id.spot_temperature);
        TextView wind = (TextView) rowView.findViewById(R.id.spot_wind);
        ImageView wind_direction = (ImageView) rowView.findViewById(R.id.spot_arrow_image);
        TextView wave = (TextView) rowView.findViewById(R.id.spot_wave);

        name.setText(spot.getName());
        temperature.setText(spot.getTemperature());
        wind.setText(spot.getWind_knots());
        wind_direction.setRotation((float)(spot.getDirection()));
        wave.setText(spot.getWave());

        return rowView;

    };
}
