package com.example.surfingpatrol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.Objects;
import java.util.UUID;

public class AddImage extends AppCompatActivity {

    Button take_pic, post_btn;
    ImageView imageView;
    private TextInputLayout location_name, description;
    User user;

    FirebaseDatabase rootNode;
    StorageReference storageRef = FirebaseStorage.getInstance().getReference();
    DatabaseReference reference;

    String image_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_image);

        user = (User)getIntent().getExtras().get("user");

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("images");

        take_pic = (Button)findViewById(R.id.take_pic_btn);
        imageView = (ImageView)findViewById(R.id.image_preview);
        post_btn = (Button)findViewById(R.id.send_post_btn);

        location_name = findViewById(R.id.post_beach_name);
        description = findViewById(R.id.spot_description);

        take_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if( takePictureIntent.resolveActivity(getPackageManager()) != null ) {
                    startActivityForResult(takePictureIntent, 123);
                }
            }
        });

        post_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageItem item = new ImageItem(user.username, location_name.getEditText().getText().toString(),image_url, description.getEditText().getText().toString());
                reference.push().setValue(item);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 123 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);

//            imageView.setDrawingCacheEnabled(true);
//            imageView.buildDrawingCache();
//            Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] image_data = baos.toByteArray();
            StorageReference uploadStorageRef = storageRef.child("SpotsImages").child(UUID.randomUUID().toString());
            UploadTask uploadTask = uploadStorageRef.putBytes(image_data);
            Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if (!task.isSuccessful()) {
                        throw task.getException();
                    }

                    // Continue with the task to get the download URL
                    return uploadStorageRef.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()) {
                        Uri downloadUri = task.getResult();
                        image_url = downloadUri.toString();
                    }
                }
            });

        }
    }
}