package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.ui.QuestionsActivity
import com.example.quizapp.utils.Constants

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val enterButton: Button = findViewById(R.id.button_enter)
        val editName: EditText = findViewById(R.id.edit_name)

        enterButton.setOnClickListener {
            if(!editName.text.isEmpty()){
                Intent(this@MainActivity,QuestionsActivity::class.java).also {
                    it.putExtra(Constants.USER_NAME,editName.text.toString())
                    startActivity(it)
                    finish()
                }
            }else{
                Toast.makeText(this@MainActivity,"Please enter your name",Toast.LENGTH_LONG).show()
            }
        }
    }
}