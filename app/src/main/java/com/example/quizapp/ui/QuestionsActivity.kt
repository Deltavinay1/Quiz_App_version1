package com.example.quizapp.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quizapp.R
import com.example.quizapp.model.Question
import com.example.quizapp.utils.Constants

class QuestionsActivity : AppCompatActivity() ,View.OnClickListener{
    private lateinit var progressBar: ProgressBar
    private lateinit var textviewprogress: TextView
    private lateinit var textviewquestion: TextView
    private lateinit var flagimage: ImageView

    private lateinit var textoption1: TextView
    private lateinit var textoption2: TextView
    private lateinit var textoption3: TextView
    private lateinit var textoption4: TextView
    private lateinit var checkButton: Button

    private lateinit var name: String
    private var score = 0
    private var currentPosition = 0
    private var selectedAnswer = 0
    private lateinit var currentquestion : Question
    private var answered = false
    private lateinit var questionsList: MutableList<Question>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)
        progressBar = findViewById(R.id.progressBar)
        textviewprogress = findViewById(R.id.text_view_progress)
        textviewquestion = findViewById(R.id.question_text_view)
        flagimage = findViewById(R.id.image_flag)

        textoption1 = findViewById(R.id.text_option1)
        textoption2 = findViewById(R.id.text_option2)
        textoption3 = findViewById(R.id.text_option3)
        textoption4 = findViewById(R.id.text_option4)
        checkButton = findViewById(R.id.button_check)


        questionsList = Constants.getQuestions()
        Log.d("QuestionSize","${questionsList.size}")

        showNextQuestion()

        if(intent.hasExtra(Constants.USER_NAME)){
            name = intent.getStringExtra(Constants.USER_NAME)!!
        }
    }

    private fun showNextQuestion(){
        if(currentPosition < questionsList.size){
            checkButton.text = "CHECK"
            currentquestion = questionsList[currentPosition]
            val question = questionsList[currentPosition]

            resetOption()
            progressBar.progress = currentPosition+1
            textviewprogress.text = "${currentPosition+1}/${progressBar.max}"
            flagimage.setImageResource(question.image)
            textviewquestion.text = question.question
            textoption1.text = question.option1
            textoption2.text = question.option2
            textoption3.text = question.option3
            textoption4.text = question.option4

            textoption1.setOnClickListener(this)
            textoption2.setOnClickListener(this)
            textoption3.setOnClickListener(this)
            textoption4.setOnClickListener(this)

            checkButton.setOnClickListener(this)
        }
        else{
            checkButton.text = "FINISH"
            Intent(this@QuestionsActivity,ResultActivity::class.java).also{
                it.putExtra(Constants.USER_NAME,name)
                it.putExtra(Constants.SCORE,score)
                it.putExtra(Constants.TOTAL_QUESTIONS,questionsList.size)
                startActivity(it)
                finish()
            }

        }
        currentPosition++
        answered = false


    }
    private fun resetOption(){
        val options= mutableListOf<TextView>()
        options.add(textoption1)
        options.add(textoption2)
        options.add(textoption3)
        options.add(textoption4)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_bg)
        }
    }

    private fun selectedOption(textview: TextView, optionNumber: Int){
        resetOption()
        selectedAnswer = optionNumber
        textview.setTextColor(Color.parseColor("#363A43"))
        textview.setTypeface(textview.typeface,Typeface.BOLD)
        textview.background = ContextCompat.getDrawable(this,R.drawable.selected_option_bg)
    }
    private fun checkAnswer(){
        answered = true;
        if(selectedAnswer == currentquestion.correctAnswer){
            when (selectedAnswer){
                1 -> textoption1.background = ContextCompat.getDrawable(this,R.drawable.currect_option_bg)
                2 -> textoption2.background = ContextCompat.getDrawable(this,R.drawable.currect_option_bg)
                3 -> textoption3.background = ContextCompat.getDrawable(this,R.drawable.currect_option_bg)
                4 -> textoption4.background = ContextCompat.getDrawable(this,R.drawable.currect_option_bg)
            }
            score++
        }else{

            when (selectedAnswer){
                1 -> textoption1.background = ContextCompat.getDrawable(this,R.drawable.wrong_option_bg)
                2 -> textoption2.background = ContextCompat.getDrawable(this,R.drawable.wrong_option_bg)
                3 -> textoption3.background = ContextCompat.getDrawable(this,R.drawable.wrong_option_bg)
                4 -> textoption4.background = ContextCompat.getDrawable(this,R.drawable.wrong_option_bg)
            }
            when (currentquestion.correctAnswer){
                1 -> textoption1.background = ContextCompat.getDrawable(this,R.drawable.currect_option_bg)
                2 -> textoption2.background = ContextCompat.getDrawable(this,R.drawable.currect_option_bg)
                3 -> textoption3.background = ContextCompat.getDrawable(this,R.drawable.currect_option_bg)
                4 -> textoption4.background = ContextCompat.getDrawable(this,R.drawable.currect_option_bg)
            }
        }
        checkButton.text = "NEXT"
    }
    override fun onClick(view: View?) {

        when(view?.id){
            R.id.text_option1 -> {
                if (!answered) selectedOption(textoption1, 1) }
            R.id.text_option2 -> {
                if (!answered) selectedOption(textoption2, 2) }
            R.id.text_option3 -> {
                if (!answered) selectedOption(textoption3, 3) }
            R.id.text_option4 -> {
                if (!answered) selectedOption(textoption4, 4) }
            R.id.button_check -> {
                if(selectedAnswer != 0){
                if(!answered){
                    checkAnswer()
                }
                else{
                    showNextQuestion()
                    selectedAnswer = 0
                }

            }
                else{
                    Toast.makeText(this@QuestionsActivity,"Please Section option",Toast.LENGTH_LONG).show()
            }
        }
    }
}
    }

