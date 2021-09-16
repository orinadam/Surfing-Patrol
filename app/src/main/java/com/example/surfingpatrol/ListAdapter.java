package com.example.surfingpatrol;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Item> {

    private int resourceLayout;
    private Context mContext;

    public ListAdapter(Context context, int resource, List<Item> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }

        Item p = getItem(position);

        if (p != null) {
            TextView date = (TextView) v.findViewById(R.id.date);
            TextView hour = (TextView) v.findViewById(R.id.six_am_time);
            TextView height = (TextView) v.findViewById(R.id.six_am_height);
            TextView period = (TextView) v.findViewById(R.id.six_am_period);
            TextView description = (TextView) v.findViewById(R.id.six_am_desc);
/*            TextView hour = (TextView) v.findViewById(R.id.six_am_time);
            TextView height = (TextView) v.findViewById(R.id.six_am_height);
            TextView period = (TextView) v.findViewById(R.id.six_am_period);
            TextView description = (TextView) v.findViewById(R.id.six_am_desc);
            TextView hour = (TextView) v.findViewById(R.id.six_am_time);
            TextView height = (TextView) v.findViewById(R.id.six_am_height);
            TextView period = (TextView) v.findViewById(R.id.six_am_period);
            TextView description = (TextView) v.findViewById(R.id.six_am_desc);*/
/*            if (tt1 != null) {
                tt1.setText(""+p.);
            }

            if (tt2 != null) {
                tt2.setText(""+position);
            }*/

        }

        return v;
    }

}
