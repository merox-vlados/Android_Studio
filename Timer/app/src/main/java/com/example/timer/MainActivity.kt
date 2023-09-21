package com.example.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.timer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var text = ""

        binding.imageButton.setOnClickListener {
            var text = binding.editTextNumberMinutes.text.toString().trim()

        }

        var minutes = text.toInt()



        var CountDownTimer = object : CountDownTimer(minutes.toLong() * 60000 , 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val minutes = millisUntilFinished / 60000
                val remainingSeconds = seconds % 60
                binding.timerScreen.text = "Осталось $minutes:$remainingSeconds"
            }

            override fun onFinish() {
                binding.timerScreen.text = "Время окончено"
            }
        }

        binding.buttonStart.setOnClickListener({
            CountDownTimer.start()
        })
    }
}