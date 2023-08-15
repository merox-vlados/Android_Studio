package com.example.messengerfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {

    private EditText editTextRegistrationEmail;
    private EditText editTextRegistrationPassword;
    private EditText editTextRegistrationName;
    private EditText editTextRegistrationLastName;
    private EditText editTextRegistrationAge;
    private Button buttonRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initViews();

        buttonRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = UsersActivity.newIntent(RegistrationActivity.this);
                startActivity(intent);
            }
        });
    }

    private void initViews(){
        editTextRegistrationEmail = findViewById(R.id.editTextRegistrationEmail);
        editTextRegistrationPassword = findViewById(R.id.editTextRegistrationPassword);
        editTextRegistrationName = findViewById(R.id.editTextRegistrationName);
        editTextRegistrationLastName = findViewById(R.id.editTextRegistrationLastName);
        editTextRegistrationAge = findViewById(R.id.editTextRegistrationAge);
        buttonRegistration = findViewById(R.id.buttonRegistration);
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, RegistrationActivity.class);
        return intent;
    }
}