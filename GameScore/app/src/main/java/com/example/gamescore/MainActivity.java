package com.example.gamescore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int score1 = 0;
    private int score2 = 0;

    private TextView textViewScore1;

    private TextView textViewScore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "start method onCreate ");


        if(savedInstanceState != null) {
            score1 = savedInstanceState.getInt("score1");
            score2 = savedInstanceState.getInt("score2");
        }

        textViewScore1 = findViewById(R.id.textViewScore1);
        textViewScore2 = findViewById(R.id.textViewScore2);

        updateScore1();
        updateScore2();

        textViewScore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                Log.d("MainActivity", "Clicked textViewScore1");
                score1++;
                updateScore1();
            }
        });
        textViewScore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Clicked textViewScore2");
                score2++;
                updateScore2();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "start method onStart ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "start method onResume ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "start method onPause ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "start method onRestart ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "start method onStop ");
    }

    private void updateScore1() {
        textViewScore1.setText(String.valueOf(score1));
    }

    private void updateScore2() {
        textViewScore2.setText(String.valueOf(score2));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("score1",score1);
        outState.putInt("score2",score2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "start method onDestroy ");
    }
}