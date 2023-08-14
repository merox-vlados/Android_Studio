package com.example.messengerfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        String email = editTextTextEmail.getText().toString();
        String password = editTextTextPassword.getText().toString();

        if (isValidEmail(email) && isValidPassword(password)) {
            ///
        } else {
            if(!isValidEmail(email)) {
                Toast.makeText(LoginActivity.this, "The email address is badly formatted", Toast.LENGTH_SHORT);
            } else if(!isValidPassword(password)) {
                Toast.makeText(LoginActivity.this, "The password has to be minimum 6 characters long!", Toast.LENGTH_SHORT);
            } else {
                Toast.makeText(LoginActivity.this, "The email address and password are badly formatted", Toast.LENGTH_SHORT);
            }
        }


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
}