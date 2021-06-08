package com.example.tarea_1_a01197049;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button cnvButton;
    private EditText input;
    private double celsius;
    private double fahrenheit;
    private String result;
    private int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cnvButton = findViewById(R.id.convertButton);
        input = findViewById(R.id.inputEditText);

        cnvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().isEmpty()) {
                    result = "Please enter a value.";
                    Toast.makeText(getApplicationContext(), result, duration).show();
                    return;
                }

                fahrenheit = Double.parseDouble(input.getText().toString());
                celsius = (fahrenheit - 32) * 5 / 9;
                result = fahrenheit + " degrees Fahrenheit is equal to " + String.format("%.2f", celsius) + " degrees Celsius";
                Toast.makeText(getApplicationContext(), result, duration).show();
            }
        });

    }
}