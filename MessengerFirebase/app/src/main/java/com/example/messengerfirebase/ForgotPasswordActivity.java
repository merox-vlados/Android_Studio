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

public class ForgotPasswordActivity extends AppCompatActivity {

    private TextView textViewForgotPassword;
    private EditText editTextTextForgotPasswordEmailAddress;
    private Button buttonForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        initViews();

        buttonForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        ForgotPasswordActivity.this,
                        "The reset link has been successfully sent",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }

    private void initViews() {
        textViewForgotPassword = findViewById(R.id.textViewForgotPassword);
        editTextTextForgotPasswordEmailAddress = findViewById(R.id.editTextTextForgotPasswordEmailAddress);
        buttonForgotPassword = findViewById(R.id.buttonForgotPassword);
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ForgotPasswordActivity.class);
        return intent;
    }

}