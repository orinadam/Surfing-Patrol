package com.example.surfingpatrol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ImagesAdapter  extends ArrayAdapter<ImageItem> {
    ArrayList<ImageItem> imagesList = new ArrayList<>();

    public ImagesAdapter(Context context, int textViewResourceId, ArrayList<ImageItem> objects) {
        super(context, textViewResourceId, objects);
        imagesList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.image_row, null);
        TextView beach_name = (TextView) v.findViewById(R.id.beach_name);
        TextView publisher_name = (TextView) v.findViewById(R.id.publishe_user_name);
        TextView conditions_desc = (TextView) v.findViewById(R.id.conditions_desc);
        ImageView imageView = (ImageView) v.findViewById(R.id.beach_image);
        beach_name.setText(imagesList.get(position).getBeach_name());
        publisher_name.setText(imagesList.get(position).getPublisher());
        conditions_desc.setText(imagesList.get(position).getDescription());
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/surfing-patrol.appspot.com/o/SpotsImages%2F313c40c9-2f6f-4f0d-aa3e-a1082655d03b?alt=media&token=bf189771-4ef4-4659-af44-07263a25b17a").into(imageView);
        return v;

    }

}
