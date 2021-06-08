package com.delnortedevs.roompractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.delnortedevs.roompractice.db.TvShow;
import com.delnortedevs.roompractice.db.appDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}