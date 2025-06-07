package com.example.quizapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.MainActivity
import com.example.quizapp.R
import com.example.quizapp.utils.Constants

class ResultActivity : AppCompatActivity() {
    private lateinit var resultext: TextView
    private lateinit var resultButton: Button
    private lateinit var nametext : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        resultext = findViewById(R.id.result_text)
        resultButton = findViewById(R.id.result_button)
        nametext = findViewById(R.id.name_text)

        val totalquestion = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val score = intent.getIntExtra(Constants.SCORE,0)
        val name = intent.getStringExtra(Constants.USER_NAME)
        nametext.text = "$name"
        resultext.text = "Your score is $score out $totalquestion"

        resultButton.setOnClickListener{
        Intent(this@ResultActivity,MainActivity::class.java).also{
            startActivity(it)
            finish()
         }
        }
    }
}