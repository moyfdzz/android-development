package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Resultados extends AppCompatActivity {
    TextView numErrores;
    Integer counter = 0;
    String nuevoNumErrores;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        numErrores = findViewById(R.id.R_TV_numErrores);
        extras = getIntent().getExtras();

        if (extras != null) {
            counter = extras.getInt(Pregunta1.KEY_COUNTER);
            nuevoNumErrores = getResources().getString(R.string.TV_numErrores) + " " + counter + " veces";
            numErrores.setText(nuevoNumErrores);
        }

    }
}