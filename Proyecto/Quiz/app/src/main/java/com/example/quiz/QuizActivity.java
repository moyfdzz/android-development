package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    public String Questions[] = {
            "Pikachu es el mejor pokemon",
            "2 + 2 = 4",
            "Kong le gana a Godzilla",
            "El mar es azul",
            "la pizza es mejor que los tacos"
    };

    public boolean answers[] = {false, true, false, true, false};

    private int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView question = (TextView) findViewById(R.id.question1);
        Button true_btn = (Button) findViewById(R.id.button1);
        Button false_btn = (Button) findViewById(R.id.button2);
        Button next = (Button) findViewById(R.id.btn_next);

        if (savedInstanceState != null) {
            num = savedInstanceState.getInt("count");
        }
        question.setText(Questions[num]);


    }


    public void nextQuestion(View v){
        num++;
        TextView question = (TextView) findViewById(R.id.question1);
        question.setText(Questions[num]);
    }

    public void chooseTrue(View v){
        showToast(v,true);
    }

    public void chooseFalse(View v){
        showToast(v,false);
    }

    public void showToast(View v, boolean value){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.activity_next, (ViewGroup) findViewById(R.id.toast_root));

        TextView toastText = layout.findViewById(R.id.toast_text);

        String res = (value == answers[num]) ? "Correct!":"Incorrect";
        toastText.setText(res);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM,0,-100);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        toast.show();
    }
}