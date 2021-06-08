package com.example.tarea3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_COUNTER = "key_counter";
    public static final Integer ACTIVITY_2 = 200;
    Button buttonSayHello, buttonCount;
    TextView textViewCounter;
    Integer counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSayHello = findViewById(R.id.button_sayHello);
        buttonCount = findViewById(R.id.button_count);
        textViewCounter = findViewById(R.id.textView_counter);

        textViewCounter.setText(String.valueOf(counter));

        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                textViewCounter.setText(String.valueOf(counter));
            }
        });
    }

    public void goToAct2(View view) {
        Intent i = new Intent(this, Activity2.class);
        i.putExtra(KEY_COUNTER, counter);
        startActivityForResult(i, ACTIVITY_2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACTIVITY_2) {
            Integer counterReply = data.getIntExtra(Activity2.KEY_COUNTER_REPLY, -2);

            if (counterReply != -1) {
                counter = counterReply;
                textViewCounter.setText(String.valueOf(counter));
            }
        }
    }
}