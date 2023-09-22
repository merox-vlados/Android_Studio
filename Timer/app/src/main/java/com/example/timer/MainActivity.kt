package com.example.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.timer.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var countDownTimer: CountDownTimer? = null

    private var editTextNumberMinutes = ""

    private var isTimerRunning = false

    private var remainingTimeMillis: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imageButton.setOnClickListener {
            editTextNumberMinutes = binding.editTextNumberMinutes.text.toString().trim()
            binding.editTextNumberMinutes.text.clear()

        }

        binding.buttonStart.setOnClickListener {
            val inputTimeString = editTextNumberMinutes
            if (inputTimeString.isNotEmpty()) {

                val inputTimeMillis = inputTimeString.toLong() * 60000

                if (isTimerRunning) {
                    stopCountDownTimer()
                    binding.buttonStart.text =
                        "Start" // Измените текст кнопки на "Старт" или другой подходящий
                } else {
                    if (remainingTimeMillis > 0) {
                        startCountDownTimer(remainingTimeMillis)
                    } else {
                        startCountDownTimer(inputTimeMillis)
                    }

                    countDownTimer?.start()
                    binding.buttonStart.text =
                        "Stop" // Измените текст кнопки на "Стоп" или другой подходящий
                    isTimerRunning = true
                }


            } else {
                Toast.makeText(this, "Enter the correct time value.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonStop.setOnClickListener {
            countDownTimer?.cancel() // Остановка таймера без сброса значений
        }

        binding.buttonReset.setOnClickListener {
            resetCountDownTimer()
            binding.timerScreen.text = "00:00"
        }

    }

    private fun startCountDownTimer(inputTimeMillis: Long) {
        countDownTimer = object : CountDownTimer(inputTimeMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val minutes = millisUntilFinished / 60000
                val remainingSeconds = seconds % 60
                binding.timerScreen.text = "$minutes:$remainingSeconds"

                remainingTimeMillis = millisUntilFinished
            }

            override fun onFinish() {
                binding.timerScreen.text = "Time over"
                isTimerRunning = false
                remainingTimeMillis = 0
            }
        }
        countDownTimer?.start()

    }

    private fun stopCountDownTimer() {
        countDownTimer?.cancel()
        isTimerRunning = false
    }

    private fun resetCountDownTimer() {
        countDownTimer?.cancel() // Остановить текущий таймер, если он активен
        countDownTimer = null // Установить таймер в null, чтобы сбросить его
        remainingTimeMillis = 0
    }
}


//        var inputTimeMillis: Long = editTextNumberMinutes.toLong()
//
//        var сountDownTimer = object : CountDownTimer(inputTimeMillis * 60000, 1000) {
//            override fun onTick(millisUntilFinished: Long) {
//                val seconds = millisUntilFinished / 1000
//                val minutes = millisUntilFinished / 60000
//                val remainingSeconds = seconds % 60
//                binding.timerScreen.text = "Осталось $minutes:$remainingSeconds"
//            }
//
//            override fun onFinish() {
//                binding.timerScreen.text = "Время окончено"
//            }
//        }


//        binding.buttonStart.setOnClickListener {
//            if(editTextNumberMinutes != "") {
//
//                Log.d("MyApp", "Input string: $inputTimeMillis ${inputTimeMillis is Long}")
//
//                if (inputTimeMillis != 0L) {
//
//                    сountDownTimer.start()
//
//                } else {
//                    Toast.makeText(this, "Введите корректное значение", Toast.LENGTH_SHORT).show()
//                }
//            } else {
//                Toast.makeText(this, "Введите корректное значение", Toast.LENGTH_SHORT).show()
//            }
//        }