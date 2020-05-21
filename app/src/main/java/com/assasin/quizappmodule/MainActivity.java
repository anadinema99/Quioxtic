package com.assasin.quizappmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button falseButton;
    private Button trueButton;
    private ImageButton nextButton;
    private ImageButton prevButton;
    private Button submitButton;
    private int currentQuestion = 0;
    private int totalScore = 0;
    private TextView questionTextView;

    //https://jsonplaceholder.typicode.com/todos/1

    private Question[] questionBank = new Question[] {

            new Question(R.string.question_1,true),
            new Question(R.string.question_2,false),
            new Question(R.string.question_3,false),
            new Question(R.string.question_4,false),
            new Question(R.string.question_5,true),
            new Question(R.string.question_6,true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Question question = new Question(R.string.question_1, true);

        falseButton = findViewById(R.id.true_button);
        trueButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next_button);
        prevButton = findViewById(R.id.prev_button);
        submitButton = findViewById(R.id.submit_button);
        questionTextView = findViewById(R.id.question_txt);

        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
        submitButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.true_button:
                checkAnswer(true);
                if (currentQuestion == (questionBank.length-1))
                    Toast.makeText(MainActivity.this, "Last Question", Toast.LENGTH_LONG).show();
//                    currentQuestion = (currentQuestion+1)%questionBank.length;
                else
                {
                    currentQuestion = (currentQuestion+1)%questionBank.length;
                    updateQuestion();
                }
                break;

            case R.id.false_button:
                checkAnswer(false);
                if (currentQuestion == (questionBank.length-1))
                    Toast.makeText(MainActivity.this, "Last Question", Toast.LENGTH_LONG).show();
//                    currentQuestion = (currentQuestion+1)%questionBank.length;
                else
                {
                    currentQuestion = (currentQuestion+1)%questionBank.length;
                    updateQuestion();
                }
                break;

            case R.id.next_button:
                if (currentQuestion == (questionBank.length-1))
                    Toast.makeText(MainActivity.this, "Last Question", Toast.LENGTH_LONG).show();
//                    currentQuestion = (currentQuestion+1)%questionBank.length;
                else
                    {
                        currentQuestion = (currentQuestion+1)%questionBank.length;
                        updateQuestion();
                    }
                break;

            case R.id.prev_button:
                if (currentQuestion==0)
                    Toast.makeText(MainActivity.this, "First Question", Toast.LENGTH_LONG).show();
//                    currentQuestion=questionBank.length -1;
                else
                    {
                        currentQuestion = (currentQuestion-1)%questionBank.length;
                        updateQuestion();
                    }
                break;

            case R.id.submit_button:

                Intent gotoInt = new Intent(MainActivity.this, result.class);
                gotoInt.putExtra("Score", String.valueOf(totalScore));
                startActivity(gotoInt);
                break;

        }

    }

    private void updateQuestion()
    {
        Log.d("Current ", "onClick: " + currentQuestion);
        questionTextView.setText(questionBank[currentQuestion].getAnswerRedID());
    }

    private void checkAnswer (boolean userAnswer)
    {
        boolean corrAnswer = questionBank[currentQuestion].isAnswerTrue();

        if (userAnswer == corrAnswer)
            totalScore+=10;
        else
            totalScore+=0;
    }
}
