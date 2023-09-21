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

        var CountDownTimer = object : CountDownTimer(700000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                binding.timerScreen.text = "Осталось $seconds секунд"
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