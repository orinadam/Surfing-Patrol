package com.example.surfingpatrol;

import android.content.Context;

import androidx.core.view.ViewCompat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Waves list custom asapter
 * Arranges all waves item and shows them in a listview
 * creates a viewable wave forecast
 */
public class ListAdapter extends ArrayAdapter<WaveItem> {

    private int resourceLayout;
    private Context mContext;


    public ListAdapter(Context context, int resource, List<WaveItem> items) {
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
    /*
        Creating a view for each waveItem and set the data on UI
        gets the specific position of the item on the list
    * */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;


        if (v == null) {

            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);

            WaveItem p = getItem(position);
            for(int i = 0; i < 3; i++) {

                TableRow table_row = LayoutInflater.from(v.getContext()).inflate(R.layout.wave_item_row, v.findViewById(R.id.table)).findViewById(R.id.row);
                table_row.setId(generateUniqueId());

                TextView hour = (TextView) v.findViewById(R.id.hour);
                TextView height = (TextView) v.findViewById(R.id.height);
                TextView period = (TextView) v.findViewById(R.id.period);
                TextView description = (TextView) v.findViewById(R.id.description);

                hour.setText(p.waveItems.get(i).hour);
                height.setText(p.waveItems.get(i).height);
                period.setText(p.waveItems.get(i).period);
                description.setText(p.waveItems.get(i).description);

                hour.setId(generateUniqueId());
                height.setId(generateUniqueId());
                period.setId(generateUniqueId());
                description.setId(generateUniqueId());

                TextView date = (TextView) v.findViewById(R.id.date);
                if (date != null) {
                    date.setText(p.date);
                }
            }

        }


        return v;
    }

}
