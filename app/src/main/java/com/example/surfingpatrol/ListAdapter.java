package com.example.surfingpatrol;

import android.content.Context;

import androidx.core.view.ViewCompat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;


/**
 *
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

        /*if (p != null) {
            for(int i = 0; i < p.get_wave_items().length; i++){
                TableRow table_row = LayoutInflater.from(v.getContext()).inflate(R.layout.wave_item_row, v.findViewById(R.id.table)).findViewById(R.id.row);
                table_row.setId(generateUniqueId());
                TextView hour = (TextView) v.findViewById(R.id.hour);
                TextView height = (TextView) v.findViewById(R.id.height);
                TextView period = (TextView) v.findViewById(R.id.period);
                TextView description = (TextView) v.findViewById(R.id.description);
                hour.setText(p.get_wave_items()[i].get_hour());
                height.setText(p.get_wave_items()[i].get_height());
                period.setText(p.get_wave_items()[i].get_period());
                description.setText(p.get_wave_items()[i].get_description());
                hour.setId(generateUniqueId());
                height.setId(generateUniqueId());
                period.setId(generateUniqueId());
                description.setId(generateUniqueId());

            }
            TextView date = (TextView) v.findViewById(R.id.date);
            if (date != null) {
                date.setText(p.get_date());
            }
*/
       // }

        return v;
    }

}
