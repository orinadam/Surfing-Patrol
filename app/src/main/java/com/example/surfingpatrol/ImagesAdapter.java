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

/**
 * Images Cudtom adapter
 * Takes all images and posts and shows the, in a listview
 */

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

        // Setting all widgets
        beach_name.setText(imagesList.get(position).getBeach_name());
        publisher_name.setText(imagesList.get(position).getPublisher());
        conditions_desc.setText(imagesList.get(position).getDescription());

        Picasso.get().load(imagesList.get(position).getImage_url()).into(imageView); // Getting image from url


        return v;

    }

}
