package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Pregunta3 extends AppCompatActivity {
    TextView numErrores;
    Button firstAnswer, secondAnswer, thirdAsnwer, fourthAnswer;
    Integer counter = 0;
    String nuevoNumErrores;
    private final Integer duration = Toast.LENGTH_SHORT;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta3);

        numErrores = findViewById(R.id.P1_TV_numErrores);
        firstAnswer = findViewById(R.id.P3_B_respuesta1);
        secondAnswer = findViewById(R.id.P3_B_respuesta2);
        thirdAsnwer = findViewById(R.id.P3_B_respuesta3);
        fourthAnswer = findViewById(R.id.P3_B_respuesta4);
        extras = getIntent().getExtras();

        if (extras != null) {
            counter = extras.getInt(Pregunta1.KEY_COUNTER);
            nuevoNumErrores = getResources().getString(R.string.P1_textoNumErrores) + " " + counter;
            numErrores.setText(nuevoNumErrores);
        }

        firstAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Respuesta incorrecta", duration).show();
                counter++;
                nuevoNumErrores = getResources().getString(R.string.P1_textoNumErrores) + " " + counter;
                numErrores.setText(nuevoNumErrores);
                firstAnswer.setEnabled(false);
            }
        });

        thirdAsnwer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Respuesta incorrecta", duration).show();
                counter++;
                nuevoNumErrores = getResources().getString(R.string.P1_textoNumErrores) + " " + counter;
                numErrores.setText(nuevoNumErrores);
                thirdAsnwer.setEnabled(false);
            }
        });

        fourthAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Respuesta incorrecta", duration).show();
                counter++;
                nuevoNumErrores = getResources().getString(R.string.P1_textoNumErrores) + " " + counter;
                numErrores.setText(nuevoNumErrores);
                fourthAnswer.setEnabled(false);
            }
        });
    }


    public void goToResults(View view) {
        Toast.makeText(getApplicationContext(), "Respuesta correcta", duration).show();
        Intent i = new Intent(this, Resultados.class);
        i.putExtra(Pregunta1.KEY_COUNTER, counter);
        startActivity(i);
    }
}