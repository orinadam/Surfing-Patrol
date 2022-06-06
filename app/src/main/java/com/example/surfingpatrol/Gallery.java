package com.example.surfingpatrol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A screen which enables you to look at all of the posts that were uploaded by other users
 *
 */

public class Gallery extends AppCompatActivity {

    ListView images_lv;
    Button addImage;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    User user;
    ArrayList<ImageItem> posts_list = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        images_lv = findViewById(R.id.images_lv);
        addImage = findViewById(R.id.add_image_screen);

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("images");

        user = (User)getIntent().getExtras().get("user");


        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {

                posts_list = new ArrayList<>();

                for(DataSnapshot post : snapshot.getChildren()){
                    posts_list.add(post.getValue(ImageItem.class)); // Adding posts to posts_list
                }

                refredh_lv(); //refreshing listview

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });



        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), AddImage.class);
                intent.putExtra("user", user);

                startActivity(intent); //intenting to AddImage screen
            }
        });
    }

    private void refredh_lv(){

        ImagesAdapter myAdapter=new ImagesAdapter(this,R.layout.image_row,posts_list);
        images_lv.setAdapter(myAdapter);

    }
}