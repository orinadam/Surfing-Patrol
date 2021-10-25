package com.example.surfingpatrol;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class SpotListAdapter extends ArrayAdapter<Spot> {
    private int resourceLayout;
    private Context mContext;

    public SpotListAdapter(Context context, int resource, List<Spot> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
    }
    //to be continued

}
