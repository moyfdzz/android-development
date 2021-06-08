package com.example.tarea3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    public static final String KEY_COUNTER_REPLY = "key_counter_reply";
    TextView textViewAct2Counter;
    EditText editTextNCV;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        textViewAct2Counter = findViewById(R.id.textViewAct2_counter);
        editTextNCV = findViewById(R.id.editTextNumber);
        extras = getIntent().getExtras();

        if (extras != null) {
            textViewAct2Counter.setText(extras.get(MainActivity.KEY_COUNTER).toString());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Integer returnCounter;

                if (editTextNCV.getText().toString().equals("")) {
                    returnCounter = -1;
                }
                else {
                    returnCounter = Integer.parseInt(editTextNCV.getText().toString());
                }

                Intent replyIntent = new Intent();
                replyIntent.putExtra(KEY_COUNTER_REPLY, returnCounter);
                setResult(RESULT_OK, replyIntent);
                finish();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}