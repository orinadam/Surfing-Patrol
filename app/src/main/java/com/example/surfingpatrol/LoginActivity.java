package com.example.surfingpatrol;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Login Screen
 * Login to the app if you already have a user
 * if not' you can signup to the application
 * makes some validations using regex and stuff
 */
public class LoginActivity extends AppCompatActivity {

    private TextInputLayout loginUsername, loginPassword;
    Button loginButton, regButton;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    /*
        Login screen the function is called on screens loading
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginUsername = findViewById(R.id.login_username);
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);
        regButton = findViewById(R.id.reg_btn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String loginUsernameText = loginUsername.getEditText().getText().toString(); //Getting username
                String loginPasswordText = loginPassword.getEditText().getText().toString(); //Getting password

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                Query checkUser = reference.orderByChild("username").equalTo(loginUsernameText);

                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            loginUsername.setError(null);
                            loginUsername.setErrorEnabled(false);

                            String dbPassword = snapshot.child(Helpers.generateId(loginUsernameText)).child("password").getValue(String.class);
                            if(dbPassword.equals(loginPasswordText)){

                                loginUsername.setError(null);
                                loginUsername.setErrorEnabled(false);

                                User user = new User(snapshot.child(Helpers.generateId(loginUsernameText)).child("name").getValue(String.class),
                                        snapshot.child(Helpers.generateId(loginUsernameText)).child("username").getValue(String.class),
                                        snapshot.child(Helpers.generateId(loginUsernameText)).child("email").getValue(String.class),
                                        snapshot.child(Helpers.generateId(loginUsernameText)).child("password").getValue(String.class)); // Creates a user

                                Intent intent = new Intent(getApplicationContext(), SurfingSpots.class);
                                intent.putExtra("user", user); // Move user to waves screen

                                startActivity(intent);
                            }
                            else{
                                loginPassword.setError("Wrong Password");
                                loginPassword.requestFocus();
                            }
                        }
                        else{

                            loginUsername.setError("No such user exists");
                            loginUsername.requestFocus();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_reg = new Intent(getApplicationContext(), Register.class);
                startActivity(intent_reg);

            }
        });

    }
}