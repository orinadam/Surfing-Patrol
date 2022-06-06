package com.example.surfingpatrol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * Register screen
 * register to the application using this screen
 * makes validation like checking if username/email already exists etc.
 */
public class Register extends AppCompatActivity {
    TextInputLayout regName, regUsername, regEmail, regPassword;
    Button registerButton;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    boolean username_check_flag = true;
    boolean email_check_flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        regName = findViewById(R.id.reg_full_name);
        regUsername = findViewById(R.id.reg_username);
        regEmail = findViewById(R.id.reg_email);
        regPassword = findViewById(R.id.reg_password);
        registerButton = (Button) findViewById(R.id.signup_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");
                validate();
            }
        });
        return;
    }
    private void validate(){
        validateName();
    }
    private void validateName(){
        String val = regName.getEditText().getText().toString(); // Checks name validity
        if(val.isEmpty()){
            regName.setError("Field cannot be empty");
        }
        else{
            regName.setError(null);
            regName.setErrorEnabled(false);
            validatePassword();
        }
    }

    /*
    Checks username validity using regex pattern and checking with firebase
    * */
    private void validateUsername(){
        String noWhiteSpaces = "^\\S*$";
        String val = regUsername.getEditText().getText().toString();
        if(val.isEmpty()){
            regUsername.setError("Field cannot be empty");
        }else if(val.length() >= 15){
            regUsername.setError("Username too long");
        }else if(!val.matches(noWhiteSpaces)){
            regUsername.setError("White spaces are not allowed");
        }
        else{
            Query checkUser = reference.orderByChild("username").equalTo(val);
            int colorInt = getResources().getColor(R.color.white);
            ColorStateList csl = ColorStateList.valueOf(colorInt);
            regUsername.setHelperText("Checking validity...");
            regUsername.setHelperTextColor(csl);

            checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){
                        regUsername.setError("This username is already taken");
                        username_check_flag = false;
                    }
                    else{
                        regUsername.setHelperTextEnabled(false);
                        validateEmail();
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {


                }
            });

        }
    }

    /**
     *  validating email using regex
     */
    private void validateEmail(){
        String val = regEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(val.isEmpty()){
            regEmail.setError("Field cannot be empty");
        }
        else if (!val.matches(emailPattern)){
            regEmail.setError("Invalid email address");
        }
        else{
            Query checkUser = reference.orderByChild("email").equalTo(val);
            int colorInt = getResources().getColor(R.color.white);
            ColorStateList csl = ColorStateList.valueOf(colorInt);
            regEmail.setHelperText("Checking validity...");
            regEmail.setHelperTextColor(csl);
            checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){
                        regEmail.setError("A user with this email already exists");
                        email_check_flag = false;
                    }
                    else{
                        regEmail.setHelperTextEnabled(false);
                        valid();
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
    private void validatePassword(){
        String val = regPassword.getEditText().getText().toString();
        String passwordVal = "^" + "(?=.*[A-Za-z])" + "(?=.*\\d)" + "[A-Za-z\\d]" + "{8,}" + "$";
        if(val.isEmpty()){
            regPassword.setError("Field cannot be empty");
        }
        else if (!val.matches(passwordVal)){
            regPassword.setError("Password is too weak");
        }
        else{
            regPassword.setError(null);
            regPassword.setErrorEnabled(false);
            validateUsername();
        }
    }
    private void valid()
    {
        String name = regName.getEditText().getText().toString();
        String username = regUsername.getEditText().getText().toString();
        String email = regEmail.getEditText().getText().toString();
        String password = regPassword.getEditText().getText().toString();

        User user = new User(name, username, email, password);

        reference.child(user.generateId()).setValue(user); // Saving user into firebase

        Intent intent = new Intent(getApplicationContext(), SurfingSpots.class);
        intent.putExtra("user", user);

        startActivity(intent);
    }
}

