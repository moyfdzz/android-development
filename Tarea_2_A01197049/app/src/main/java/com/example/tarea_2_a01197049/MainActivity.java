package com.example.tarea_2_a01197049;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView questDisplayed;
    private Button trueButton, falseButton, nextButton;
    private Question[] questions = new Question[5];
    private int indexQuestion = 0;
    private int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            indexQuestion = savedInstanceState.getInt("SAVED_INDEX");
        }

        trueButton = findViewById(R.id.buttonTrue);
        falseButton = findViewById(R.id.buttonFalse);
        nextButton = findViewById(R.id.buttonNext);
        questDisplayed = findViewById(R.id.questionDisplayed);

        questions[0] = new Question(getResources().getStringArray(R.array.questions)[0], getResources().getBoolean(R.bool.answer1));
        questions[1] = new Question(getResources().getStringArray(R.array.questions)[1], getResources().getBoolean(R.bool.answer2));
        questions[2] = new Question(getResources().getStringArray(R.array.questions)[2], getResources().getBoolean(R.bool.answer3));
        questions[3] = new Question(getResources().getStringArray(R.array.questions)[3], getResources().getBoolean(R.bool.answer4));
        questions[4] = new Question(getResources().getStringArray(R.array.questions)[4], getResources().getBoolean(R.bool.answer5));

        questDisplayed.setText(questions[indexQuestion].getQuestion());

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questions[indexQuestion].getAnswer()) {
                    Toast.makeText(getApplicationContext(), "Correct!", duration).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Incorrect!", duration).show();
                }
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!questions[indexQuestion].getAnswer()) {
                    Toast.makeText(getApplicationContext(), "Correct!", duration).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Incorrect!", duration).show();
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indexQuestion == questions.length - 1) {
                    Toast.makeText(getApplicationContext(), "There are no more questions!", duration).show();
                    return;
                }
                else {
                    indexQuestion++;
                    questDisplayed.setText(questions[indexQuestion].getQuestion());
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("SAVED_INDEX", indexQuestion);
        super.onSaveInstanceState(outState);
    }
}