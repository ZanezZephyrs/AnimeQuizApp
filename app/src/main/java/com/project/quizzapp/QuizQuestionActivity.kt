package com.project.quizzapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int=1;
    private var mQuestionList: ArrayList<Question>?=null;
    private var mSelectedOptionPosition:Int=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        mQuestionList= Constants.getQuestions()

        setQuestion()

        tv_option_one.setOnClickListener(this);
        tv_option_two.setOnClickListener(this);
        tv_option_three.setOnClickListener(this);
        tv_option_four.setOnClickListener(this);
        btn_submit.setOnClickListener(this);

    }

    private fun setQuestion(){

        val question:Question?=mQuestionList!![mCurrentPosition-1]

        defaultOptionsView();

        if(mCurrentPosition==mQuestionList!!.size){
            btn_submit.text="FINISH"
        }else{
            btn_submit.text="Submit"
        }

        tv_question.text=question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text=question.optionOne
        tv_option_two.text=question.optionTwo
        tv_option_three.text=question.optionThree
        tv_option_four.text=question.optionFour
        var progressText="${mCurrentPosition-1}/${mQuestionList!!.size}"
        tv_progress.text=progressText
    }

    private fun defaultOptionsView(){
        val options=ArrayList<TextView>();
        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)

        for(option in options){
            option.setTextColor((Color.parseColor("#7A8089")))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,
                R.drawable.default_option_back)
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one ->{SelectedOptionView(tv_option_one, 1)}
            R.id.tv_option_two ->{SelectedOptionView(tv_option_two, 2)}
            R.id.tv_option_three ->{SelectedOptionView(tv_option_three, 3)}
            R.id.tv_option_four ->{SelectedOptionView(tv_option_four, 4)}
            R.id.btn_submit ->{
                Toast.makeText(this,"Submitted", Toast.LENGTH_SHORT).show();

                if(mSelectedOptionPosition==0) {
                mCurrentPosition++

                when{
                    mCurrentPosition <= mQuestionList!!.size ->{
                        setQuestion()
                    }else -> {
                    Toast.makeText(this,"You Have Finished the quiz", Toast.LENGTH_SHORT).show();
                }
                }
            } else{
                val question= mQuestionList?.get(mCurrentPosition-1)
                if(question!!.CorrectAnswer != mSelectedOptionPosition){
                    answerView(mSelectedOptionPosition,R.drawable.wrong_answer)
                }
                answerView(question.CorrectAnswer, R.drawable.correct_answer)
                if(mCurrentPosition==mQuestionList!!.size){
                    btn_submit.text="FINISH"
                }else{
                    btn_submit.text="Go to Next Question"
                }
                mSelectedOptionPosition=0;
            }
            }


        }
    }
    private fun answerView(answer:Int, drawableView:Int){
        when(answer){
            1->{tv_option_one.background=ContextCompat.getDrawable(this, drawableView)}
            2->{tv_option_two.background=ContextCompat.getDrawable(this, drawableView)}
            3->{tv_option_three.background=ContextCompat.getDrawable(this, drawableView)}
            4->{tv_option_four.background=ContextCompat.getDrawable(this, drawableView)}
        }
    }

    private fun SelectedOptionView(tv:TextView,selectedNumber : Int){
        defaultOptionsView();
        mSelectedOptionPosition=selectedNumber

        tv.setTextColor((Color.parseColor("#363A43")))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,
            R.drawable.selected_option_back)

    }
}
