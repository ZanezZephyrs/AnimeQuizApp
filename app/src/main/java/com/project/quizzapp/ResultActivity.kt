package com.project.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN


        val username=intent.getStringExtra(Constants.USER_NAME);
        tv_name.text=username
        val correctAnswer=intent.getIntExtra(Constants.CORRECT_ANSWERS, -1);
        val totalQuestions=intent.getIntExtra(Constants.TOTAL_QUESTIONS, -1);
        val scoreText="Your score is $correctAnswer out of $totalQuestions"

        tv_score.text=scoreText


        btn_finish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish();
        }
    }
}
