package com.example.messengerfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "MainActivity";

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        if (user == null) {
            Log.d(LOG_TAG, "Not authorized");
        } else {
            Log.d(LOG_TAG, "Authorized " + user.getUid());
        }

        FirebaseAuth.getInstance().signOut();

//        auth.createUserWithEmailAndPassword("email@email.com", "111111")
//                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//                    @Override
//                    public void onSuccess(AuthResult authResult) {
//
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.d(LOG_TAG,e.getMessage());
//                        Toast.makeText(
//                                MainActivity.this,
//                                e.getMessage(),
//                                Toast.LENGTH_SHORT
//                        ).show();
//                    }
//                });
    }
}