package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mKCButton;
    private Button mTBButton;
    private TextView nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mKCButton = findViewById(R.id.button_KC);
        mTBButton = findViewById(R.id.button_TB);
        nombre = findViewById(R.id.textView_nombre);

        mKCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Falso", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void TBClick(View view) {
        Toast.makeText(this,"Verdadero", Toast.LENGTH_SHORT).show();
        nombre.setText("Hello");
    }
}