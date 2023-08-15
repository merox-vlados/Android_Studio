package com.example.messengerfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextTextEmail;
    private EditText editTextTextPassword;
    private Button buttonLogIn;
    private TextView textViewForgotPassword;
    private TextView textViewRegister;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();



        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextTextEmail.getText().toString().trim();
                String password = editTextTextPassword.getText().toString().trim();

                if (isValidEmail(email) && isValidPassword(password)) {
                    launchUserScreen();
                } else {
                    if(!isValidEmail(email)) {
                        Toast.makeText(LoginActivity.this, "The email address is badly formatted", Toast.LENGTH_SHORT).show();
                    } else if(!isValidPassword(password)) {
                        Toast.makeText(LoginActivity.this, "The password has to be minimum 6 characters long!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchRegistrationScreen();
            }
        });


    }

    private void initViews() {
        editTextTextEmail = findViewById(R.id.editTextTextEmail);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        buttonLogIn = findViewById(R.id.buttonLogIn);
        textViewForgotPassword = findViewById(R.id.textViewForgotPassword);
        textViewRegister = findViewById(R.id.textViewRegister);
    }

    public boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(regex);
    }

    public boolean isValidPassword(String password) {
        return password.length() >= 6;
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    private void launchUserScreen() {
        Intent intent = UsersActivity.newIntent(this);
        startActivity(intent);
    }
    private void launchRegistrationScreen() {
        Intent intent = RegistrationActivity.newIntent(this);
        startActivity(intent);
    }



}