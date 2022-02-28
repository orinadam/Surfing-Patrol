package com.example.surfingpatrol;

import android.content.Context;

import androidx.core.view.ViewCompat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;


/**
 *
 */
public class WindListAdapter extends ArrayAdapter<WindItem> {

    private int resourceLayout;
    private Context mContext;

    public WindListAdapter(Context context, int resource, List<WindItem> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    private int generateUniqueId(){
        int id = 0;
        try {
            id = ViewCompat.generateViewId();
        }catch (Throwable err){
            //id = View.generateViewId();
        }
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
            WindItem p = getItem(position);
            for(int i = 0; i < 3; i++) {
                TableRow table_row = LayoutInflater.from(v.getContext()).inflate(R.layout.wind_item_row, v.findViewById(R.id.table)).findViewById(R.id.row);
                table_row.setId(generateUniqueId());

                TextView hour = (TextView) v.findViewById(R.id.hour);
                TextView strength = (TextView) v.findViewById(R.id.strength);
                ImageView direction = (ImageView) v.findViewById(R.id.direction);
                TextView description = (TextView) v.findViewById(R.id.description);

                hour.setText(p.get_wind_items().get(i).get_hour());
                strength.setText(p.get_wind_items().get(i).get_strength());
                direction.setRotation(Float.parseFloat(p.get_wind_items().get(i).get_direction()));
                description.setText(p.get_wind_items().get(i).get_description());

                hour.setId(generateUniqueId());
                strength.setId(generateUniqueId());
                direction.setId(generateUniqueId());
                description.setId(generateUniqueId());

                TextView date = (TextView) v.findViewById(R.id.date);
                if (date != null) {
                    date.setText(p.get_date());
                }
            }
        }

        return v;
    }

}