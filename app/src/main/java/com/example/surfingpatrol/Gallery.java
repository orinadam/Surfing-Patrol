package com.example.surfingpatrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {

    ListView images_lv;
    Button addImage;
    User user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        images_lv = findViewById(R.id.images_lv);
        addImage = findViewById(R.id.add_image_screen);

        user = (User)getIntent().getExtras().get("user");

        ArrayList<ImageItem> images_list = new ArrayList<>();

        images_list.add(new ImageItem("Lion","meni", "aa", "manana"));
        images_list.add(new ImageItem("Tiger","meni", "aa", "kkk"));
        images_list.add(new ImageItem("Monkey","meni", "aa", "jaja"));
        images_list.add(new ImageItem("Elephant","meni", "aa", "ad"));
        images_list.add(new ImageItem("Dog","meni", "aa", "dd"));
        images_list.add(new ImageItem("Cat","meni", "aa", "ds"));

        ImagesAdapter myAdapter=new ImagesAdapter(this,R.layout.image_row,images_list);
        images_lv.setAdapter(myAdapter);

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddImage.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }
}