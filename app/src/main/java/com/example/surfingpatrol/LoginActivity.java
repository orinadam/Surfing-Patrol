package com.example.surfingpatrol;


import android.content.Intent;
import android.os.Bundle;
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

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout loginUsername, loginPassword;
    Button loginButton;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginUsername = findViewById(R.id.login_username);
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String loginUsernameText = loginUsername.getEditText().getText().toString();
                String loginPasswordText = loginPassword.getEditText().getText().toString();

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
                                        snapshot.child(Helpers.generateId(loginUsernameText)).child("password").getValue(String.class));

                                Intent intent = new Intent(getApplicationContext(), WavesScreen.class);
                                intent.putExtra("user", user);

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

    }
}